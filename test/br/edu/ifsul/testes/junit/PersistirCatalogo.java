/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import org.junit.Test;


/**
 *
 * @author Julio Cesar
 */
public class PersistirCatalogo {
    
    public PersistirCatalogo(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Catalogo cat = new Catalogo();
        cat.setNome("TesteCatalogo1");
        cat.setDescricao("Teste descricao catalogo");
        cat.setLivraria(em.find(Livraria.class, 1));
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    
}
