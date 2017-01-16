/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.ejb;

import java.util.Properties;
import javax.inject.Inject;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testng.PropertiesBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.ebeaniginte.domain.Customer;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
public class BusinessBeanIT {

    public BusinessBeanIT() {
    }

    @Module
    @Classes(value = {BusinessBean.class, EbeanInitBean.class}, cdi = true)
    public WebApp jar() {
        return new WebApp().contextRoot("");
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
                .p("DS", "new://Resource?type=DataSource")
                .p("DS.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DS.LogSql", "false")
                .p("DS.jtaManaged", "true")
                .p("DSUnmanaged", "new://Resource?type=DataSource")
                .p("DSUnmanaged.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DSUnmanaged.LogSql", "false")
                .p("DSUnmanaged.jtaManaged", "false")
                .build();
    }

    @Inject
    private BusinessBean businessBean;

    /**
     * Test of lookupUserByName method, of class BusinessBean.
     */
    @Test
    public void testLookupUserByName() throws Exception {
        System.out.println("lookupUserByName");
        try {
            businessBean.initTest("xxx");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Customer lookupCustomerByName = businessBean.lookupCustomerByName("xxx");
        System.out.println("done");
    }

}
