package com.jpaprojeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(unique = true)
    private String codigo;
    
    private Float valor;
    

}
