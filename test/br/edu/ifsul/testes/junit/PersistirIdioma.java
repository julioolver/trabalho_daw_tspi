/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import org.junit.Test;


/**
 *
 * @author Julio Cesar
 */
public class PersistirIdioma {
    
    public PersistirIdioma(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Idioma idi = new Idioma();
        idi.setNome("Teste144");
        idi.setSigla("BRA");
        em.getTransaction().begin();
        em.persist(idi);
        em.getTransaction().commit();
    }
    
}
