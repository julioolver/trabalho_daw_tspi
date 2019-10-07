/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import org.junit.Test;


/**
 *
 * @author Julio Cesar
 */
public class PersistirAutor {
    
    public PersistirAutor(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Autor aut = new Autor();
        aut.setNome("Teste2");
        aut.setBibliografia("aadadadadada adadad adadada adadad AEAIHEAIEHAUIEHEIAUEHIAH");
        em.getTransaction().begin();
        em.persist(aut);
        em.getTransaction().commit();
    }
    
}
