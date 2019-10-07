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
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.modelo.LivroBasico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;


/**
 *
 * @author Julio Cesar
 */
public class PersistirLivro {
    
    public PersistirLivro(){
       
}
    
    @Test
    
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Livro liv = new Livro();
        liv.setISBN("1234567939");
        liv.setTitulo("Teste Titulo 1");
        liv.setResumo("Resmo livrobaisco");
        liv.setEditora("Editora 1");
        liv.setIdioma(em.find(Idioma.class,1));
        liv.setFormato(em.find(Formato.class,1));
        liv.setCodigobarras("123456789123");
        liv.setDatacadastro(Calendar.getInstance());
        liv.setAtivo(true);
        liv.setNumeropaginas(12);
        liv.setValor(50.00);
        em.getTransaction().begin();
        em.persist(liv);
        em.getTransaction().commit();
    }
    
}
