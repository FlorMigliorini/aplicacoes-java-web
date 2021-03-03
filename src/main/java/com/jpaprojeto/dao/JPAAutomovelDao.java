//package com.jpaprojeto.dao;
//
//import java.util.List;
//import com.jpaprojeto.entity.Automovel;
//import static com.jpaprojeto.util.JPAUtil.getEntityManager;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class JPAAutomovelDao implements AutomovelDao {
//
//    private EntityManager createEntityManager() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoPU");
//        EntityManager entityManager = emf.createEntityManager();
//        return entityManager;
//    }
//
//    public void salva(Automovel automotovel) {
//
//        EntityManager entityManager = createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(automotovel);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//    }
//
//    public List<Automovel> lista() {
//        
//        EntityManager entityManager = createEntityManager();
//        
//        List<Automovel> automoveis = entityManager.createQuery("SELECT a FROM Automovel a", Automovel.class).getResultList();
//        
//        entityManager.close();
//        
//        return automoveis;
//    }
//
//    public Automovel busca(String auto) {
//
//       
//        return null;
//
//    }
//}
