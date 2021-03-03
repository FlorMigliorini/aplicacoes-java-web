//package com.jpaprojeto.entity;
//
//import com.jpaprojeto.util.JPAUtil;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//public class ConsultaJPQL {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory entityManagerFactory = Persistence
//                .createEntityManagerFactory("automovelPU");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//    }
//
//    public static void ResultadosMarca(EntityManager entityManager) {
//
//        String jpql
//                = "select a from Automovel a where a where a.modelo.marca = :marca";
//
//        Marca marca = new Marca();
//
//        Query query = entityManager.createQuery(jpql, Automovel.class);
//
//        query.setParameter("marca", marca);
//
//        List<Automovel> automoveis = query.getResultList();
//
//    }
//
//    public static void Resuldos(EntityManager entityManager) {
//
//        String jpql
//                = "select a.modelo.marca.nome, a.descricao, a.preco from Automovel a";
//
//        Query query = entityManager.createQuery(jpql);
//
//        List<Object[]> result = query.getResultList();
//
//        for (Object[] row : result) {
//
//            String nomeMarca = (String) row[0];
//
//            String descricao = (String) row[1];
//
//            Float preco = (Float) row[2];
//        }
//    }
//
//    public static void OutroResultado(EntityManager entityManager) {
//
//        String jpql = "select new facesmotors.ResumoAutomovel"
//                + "(a.modelo.marca.nome, a.descricao, a.preco) from Automovel a";
//
//        Query query = entityManager.createQuery(jpql);
//
//        List<ResumoAutomovel> result = query.getResultList();
//
//    }
//
//    public static void AutomovelNamedQuery(EntityManager entityManager) {
//
//        Query query = entityManager.createNamedQuery("Automovel.listarTodos",
//                Automovel.class);
//
//        List<Automovel> automoveis = query.getResultList();
//
//    }
//
//    public static void ListarTodos(EntityManager entityManager) {
//
//        Query query = entityManager.createNamedQuery(Automovel.BUSCAR_TODOS,
//                Automovel.class);
//        
//        List<Automovel> automoveis = query.getResultList();
//
//    }
//
//}
