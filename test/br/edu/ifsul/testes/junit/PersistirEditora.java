/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Editora;
import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import org.junit.Test;


/**
 *
 * @author Julio Cesar
 */
public class PersistirEditora {
    
    public PersistirEditora(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Editora ed = new Editora();
        ed.setNome("Teste1 editora");
        em.getTransaction().begin();
        em.persist(ed);
        em.getTransaction().commit();
    }
    
}
