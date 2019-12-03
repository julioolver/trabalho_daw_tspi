/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Julio Cesar
 */
@Entity
@Table(name = "tb_livrobasico")
@Inheritance(strategy = InheritanceType.JOINED)

public class LivroBasico implements Serializable{
    
    @Id
//    @SequenceGenerator (name = "seq_livrobasico", sequenceName = "seq_livrobasico_id",
//    allocationSize = 13)
    
   // @GeneratedValue(generator = "seq_livrobasico", strategy = GenerationType.SEQUENCE)
    //@Column(name = "isbn", nullable = false, length = 13)
    @NotBlank(message = "ISBN deve ser Informado")
    @Length(max = 18, message = "ISBN não pode ter mais que {max} caracteres")
    String ISBN;
    
    @NotBlank(message = "O título deve ser Informado")
    @Length(max = 50, message = "O título não pode ter mais que {max} caracteres")
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    
    @NotBlank(message = "O resumo deve ser Informado")
    @Length(max = 150, message = "O resumo não pode ter mais que {max} caracteres")
    @Column(name = "resumo", nullable = false, length = 150)
    private String resumo;
    
    @NotBlank(message = "O editora deve ser Informado")
    @Length(max = 50, message = "O editora não pode ter mais que {max} caracteres")
    @Column(name = "editora", nullable = false, length = 50)
    private String editora;
//    
//    @ManyToOne
//    @NotNull(message = "O autor deve ser informado")
//    @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false)
//    private Autor autor;
    
     @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_livroautor", 
            joinColumns = 
                    @JoinColumn(name = "livrobasico", referencedColumnName = "isbn", nullable = false), 
            inverseJoinColumns = 
                    @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false))
    private Set<Autor> livroautor = new HashSet<>();  

        public LivroBasico(){
        
    }
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the id to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the autor
     */
    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the livroautor
     */
    public Set<Autor> getLivroautor() {
        return livroautor;
    }

    /**
     * @param livroautor the livroautor to set
     */
    public void setLivroautor(Set<Autor> livroautor) {
        this.livroautor = livroautor;
    }

}