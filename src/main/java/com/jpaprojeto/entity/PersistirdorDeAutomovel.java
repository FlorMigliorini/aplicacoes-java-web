///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.jpaprojeto.entity;
//
//import com.jpaprojeto.util.JPAUtil;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;
//
///**
// *
// * @author florm
// */
//public class PersistirdorDeAutomovel {
//
//    public static void main(String[] args) {
//
//        Automovel auto = new Automovel();
//        auto.setId(1);
//
//        auto.setAnoFabricacao(2010);
//        auto.setModelo("Audi");
//        auto.setAnoModelo(2011);
//        auto.setMarca("Alema");
//        auto.setObservacoes("Nunca foi batido");
//
//        EntityManager em = JPAUtil.getEntityManager();
//        Query q = em.createQuery("select a from Automovel a", Automovel.class);
//        List<Automovel> autos = q.getResultList();
//
//        for (Automovel a : autos) {
//            System.out.println(a.getMarca());
//        }
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
////		em.remove(auto);
//        em.persist(auto);
//        tx.commit();
//        em.close();
//    }
//
//}
