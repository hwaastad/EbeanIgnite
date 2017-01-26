/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.ejb;

import io.ebean.EbeanServerFactory;
import io.ebean.config.ContainerConfig;
import io.ebean.config.ServerConfig;
import io.ebean.config.dbplatform.hsqldb.HsqldbPlatform;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.waastad.ebeaniginte.domain.User;

/**
 *
 * @author helge
 */
@Singleton
@Startup
@Slf4j
public class EbeanInitBean {
    
    @Resource(name = "DSUnmanaged")
    private DataSource dsu;
    
    @PostConstruct
    public void init() {
        log.info("Initilizing Ebean and Ignite......");
        
//        ContainerConfig cc = new ContainerConfig();
//        cc.setClusterActive(true);
//        Properties properties = new Properties();
//        properties.put("ebean.cluster.localHostPort", "127.0.0.1:9942");
//        properties.put("ebean.cluster.members", "127.0.0.1:9942");
//        cc.setProperties(properties);
//        EbeanServerFactory.initialiseContainer(cc);
        
        ServerConfig config = new ServerConfig();
        config.loadFromProperties();
        config.setDataSource(dsu);
        config.setUseJtaTransactionManager(false);
        config.setName("TestServer");
        config.setDatabasePlatform(new HsqldbPlatform());
        config.setRegister(true);
        config.setDefaultServer(true);
        config.setDdlRun(true);
        config.setDdlGenerate(true);
        config.setAutoCommitMode(false);
        config.addPackage(User.class.getPackage().getName());

//        //Ignite config
//        IgniteConfiguration ic = new IgniteConfiguration();
//        ic.setClientMode(true);
//        TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();
//        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
//        discoverySpi.setAddressResolver(new MyAddressResolver());
////        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47501"));
//        ipFinder.setAddresses(Arrays.asList("rancher-01.lab.dax.local"));
//        discoverySpi.setIpFinder(ipFinder);
//        ic.setDiscoverySpi(discoverySpi);
//        
//        config.putServiceObject("igniteConfiguration", ic);
//        
        EbeanServerFactory.create(config);
    }
    
    @PreDestroy
    public void destroy() {
        EbeanServerFactory.shutdown();
    }
    
}
