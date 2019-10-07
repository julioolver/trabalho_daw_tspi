/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Editora;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.LivroBasico;
import javax.persistence.EntityManager;
import org.junit.Test;


/**
 *
 * @author Julio Cesar
 */
public class PersistirLivroBaisco {
    
    public PersistirLivroBaisco(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        LivroBasico livb = new LivroBasico();
        livb.setISBN("12345671");
        livb.setTitulo("Teste Titulo 1");
        livb.setResumo("Resmo livrobaisco");
       // livb.setAutor(em.find(Autor.class, 1));
       livb.getLivroautor().add(em.find(Autor.class, 1));
        livb.setEditora("Editora 2 livro");
        em.getTransaction().begin();
        em.persist(livb);
        em.getTransaction().commit();
    }
    
}
