/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.domain;

import javax.persistence.Column;
import org.waastad.ebeaniginte.domain.finder.PetFinder;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
@AllArgsConstructor
public class Pet extends BaseModel {

    public static final PetFinder find = new PetFinder();

    private String name;
    @Column(nullable = false)
    private Integer age;

    public Pet(String name) {
        this.name = name;
    }

    @ManyToOne(targetEntity = User.class)
    private User user;
}
