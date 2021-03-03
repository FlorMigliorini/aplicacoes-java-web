package com.jpaprojeto.bean;

import com.jpaprojeto.entity.Modelo;
import com.jpaprojeto.persistence.QueryDataModel;
import com.jpaprojeto.util.JPAUtil;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.primefaces.model.LazyDataModel;

@ManagedBean
@ViewScoped
public class ModeloBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Modelo modelo;
    private List<Modelo> modelos;

    private LazyDataModel<Modelo> modelosLazyDataModel;

    @PostConstruct
    public void init() {
        modelo = new Modelo();
    }

    public String salvar(Modelo modelo) {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(modelo);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modelo salvo com sucesso!"));

        return "listar";
    }

    public LazyDataModel<Modelo> getModelosLazyDataModel() {
        if (modelosLazyDataModel == null) {
            String jpql = "select m from Modelo m";
            String count = "select count(m.id) from Modelo m";
            modelosLazyDataModel = new QueryDataModel<Modelo>(jpql, count);
        }

        return modelosLazyDataModel;
    }

    public List<Modelo> getModelos() {
        if (modelos == null) {
            modelos = JPAUtil.getEntityManager().createQuery("select m from Modelo m", Modelo.class).getResultList();
        }

        return modelos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

}
