/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.ejb;

import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.cache.ServerCacheManager;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.HsqldbPlatform;
import com.avaje.ebeaninternal.server.cache.DefaultServerCacheManager;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.IgniteCondition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.DiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.avaje.ignite.IgniteConfigBuilder;
import org.waastad.ebeaniginte.domain.User;

/**
 *
 * @author helge
 */
@Singleton
@Startup
@Slf4j
public class EbeanInitBean {
    
    @Resource(name = "DS")
    private DataSource ds;

    @PostConstruct
    public void init() {
        log.info("Initilizing Ebean and Ignite......");
        ServerConfig config = new ServerConfig();
        config.loadFromProperties();
        config.setDataSource(ds);
        config.setName("TestServer");
        config.setDatabasePlatform(new HsqldbPlatform());
        config.setRegister(true);
        config.setDefaultServer(true);

        config.addPackage(User.class.getPackage().getName());
        
        //Ignite config
        
        IgniteConfiguration ic = new IgniteConfiguration();
        ic.setClientMode(true);
        TcpDiscoverySpi discoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        ipFinder.setAddresses(Arrays.asList("10.215.154.101"));
        discoverySpi.setIpFinder(ipFinder);
        ic.setDiscoverySpi(discoverySpi);
        
        EbeanServerFactory.create(config);
    }
    
    @PreDestroy
    public void destroy(){
        EbeanServerFactory.shutdown();
    }
}
