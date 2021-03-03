package com.jpaprojeto.entity;

public class ResumoAutomovel {

    private String marca;
    
    private String modelo;
    
    private String descricao;
    
    private Float preco;

    public ResumoAutomovel(String marca, String descricao, Float preco) {
        this.marca = marca;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    
    
}
