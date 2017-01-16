/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.ejb;

import io.ebean.Ebean;
import javax.ejb.Stateless;
import org.waastad.ebeaniginte.domain.Customer;
import org.waastad.ebeaniginte.domain.Pet;
import org.waastad.ebeaniginte.domain.User;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean {

    public void lookupUserByName(String name) {

    }

    public void initTest(String name) {
        Ebean.beginTransaction();
        try {
        Pet p = new Pet("pet");
        User u = new User("user");
        Customer c = new Customer(name);
        c.save();

        u.getPets().add(p);
        c.getUsers().add(u);
        c.update();
        Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
    }

    public Customer lookupCustomerByName(String name) {
        return Customer.find.findByName(name);
    }
}
