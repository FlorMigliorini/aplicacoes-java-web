package com.jpaprojeto.persistence; //com o ?ltro implementado, se a p�gina for acessada, n�o teremos haver�mais LazyInitializationException

import com.jpaprojeto.util.JPAUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class OpenSessionAndTransactionInView implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // inicia a transa��o antes de processar o request
        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            // processa a requisi��o
            chain.doFilter(request, response);

            // faz commit
            tx.commit();

        } catch (Exception e) { // ou em caso de erro faz o rollback

            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

//  O Container chama esse m�todo depois que a inst�ncia do servlet for criada.
    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
    }

 //Esse m�todo tem como objetivo remover o servlet, limpa qualquer recurso que est� ainda ativo
    @Override
    public void destroy() {
        JPAUtil.closeEntityManagerFactory();
    }
}
