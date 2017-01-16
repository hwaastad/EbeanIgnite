/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.domain;

import org.waastad.ebeaniginte.domain.finder.CustomerFinder;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseModel {

    public static final CustomerFinder find = new CustomerFinder();

    private String name;

    @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    private List<User> users;

    public Customer(String name) {
        this.name = name;
    }

}
