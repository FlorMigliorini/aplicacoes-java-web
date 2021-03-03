package com.jpaprojeto.entity;

import javax.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Produto produto;
    private Integer quantidade;
    private boolean pedidoPopular;
}
