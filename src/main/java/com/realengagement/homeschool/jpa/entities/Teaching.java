package com.realengagement.homeschool.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teaching {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
