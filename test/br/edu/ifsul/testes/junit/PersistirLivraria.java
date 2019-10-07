/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import org.junit.Test;
import br.edu.ifsul.jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Julio Cesar
 */
public class PersistirLivraria {
    
    public PersistirLivraria(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Livraria l = new Livraria();
        l.setNome("Teste1");
        l.setSite("eee.testelivrarira.com");
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }
    
}
