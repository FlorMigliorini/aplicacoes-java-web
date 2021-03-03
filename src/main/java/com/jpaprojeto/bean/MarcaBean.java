package com.jpaprojeto.bean;

import com.jpaprojeto.entity.Marca;
import com.jpaprojeto.util.JPAUtil;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

@ManagedBean
//consiste em manter os dados contidos nele por quantas requisições forem feitas, mas desde que sejam todas para a mesma view
@ViewScoped
public class MarcaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Marca marca;

    private List<Marca> marcas;

    private boolean continuarInserindo;

    @PostConstruct
    public void init() {
        marca = new Marca();
    }

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(marca);

    }

    public List<Marca> getMarcas() {
        if (marcas == null) {
            marcas = JPAUtil.getEntityManager().createQuery("select m from Marca m", Marca.class).getResultList();
        }

        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean isContinuarInserindo() {
        return continuarInserindo;
    }

    public void setContinuarInserindo(boolean continuarInserindo) {
        this.continuarInserindo = continuarInserindo;
    }

}
