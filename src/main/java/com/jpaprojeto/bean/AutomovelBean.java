package com.jpaprojeto.bean;

import com.jpaprojeto.util.JPAUtil;
import com.jpaprojeto.entity.Automovel;
import com.jpaprojeto.entity.Marca;
import com.jpaprojeto.entity.Modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.primefaces.model.LazyDataModel;

@ManagedBean
@ViewScoped
public class AutomovelBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Automovel automovel = new Automovel();

    private List<Automovel> automoveis;

    private Marca marca;

    @PostConstruct
    public void init() {
        automovel = new Automovel();
    }

    public Automovel getAutomovel() {
        return this.automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public String Salvar(Automovel auto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(auto);

        JPAUtil.evictCache(em, Automovel.LISTAR_DESTAQUES);

//        FacesMessage msg = new FacesMessage("Automovel salvo com sucesso!");
//        FacesMessage.getCurrentInstance().addMessage(null, msg);
//        FacesMessage.getCurrentInstance().addMessage(null, new FacesMessage(""));
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Automovel salvo com sucesso");
        fc.addMessage(null, fm);

        return "listar";

    }

    public void buscarAutomoveis(Modelo modelo) {
        String jpql = "select a from Automovel a where 1=1";
        Map<String, Object> params = new HashMap<String, Object>();
        if (modelo.getMarca() != null) {
            jpql += " and a.modelo.marca = :marca";
            params.put("marca", modelo.getMarca());
        }
        if (modelo.getDescricao() != null && !modelo.getDescricao().isEmpty()) {
            jpql += " and a.modelo.descricao like :descricao";
            params.put("descricao", "%" + modelo.getDescricao() + "%");
        }

        TypedQuery<Automovel> query = JPAUtil.getEntityManager().createQuery(jpql, Automovel.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {

            query.setParameter(param.getKey(), param.getValue());
        }

        automoveis = query.getResultList();
    }

    public void excluir(Automovel automovel) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(automovel);
        tx.commit();
        em.close();
    }

    public List<Automovel> getAutomoveis() {
        if (automoveis == null) {
            automoveis = JPAUtil.getEntityManager().createNamedQuery(Automovel.LISTAR_DESTAQUES, Automovel.class).getResultList();
        }

        return automoveis;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    

}
