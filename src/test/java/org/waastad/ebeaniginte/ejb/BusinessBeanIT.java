/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.ejb;

import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;

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


    /**
     * Test of lookupUserByName method, of class BusinessBean.
     */
    @Test
    public void testLookupUserByName() throws Exception {
        System.out.println("lookupUserByName");

    }
    
}
