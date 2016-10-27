/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

    private String name;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
}
