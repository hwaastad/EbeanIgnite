/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.domain;

import org.waastad.ebeaniginte.domain.finder.UserFinder;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel {

    public static final UserFinder find = new UserFinder();

    private String name;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @OneToMany(targetEntity = Pet.class,cascade = CascadeType.ALL)
    private List<Pet> pets;

    public User(String name) {
        this.name = name;
    }

}
