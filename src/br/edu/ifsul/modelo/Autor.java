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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Julio Cesar
 */
@Entity
@Table(name = "tb_autor")
public class Autor implements Serializable{
    
    @Id
    @SequenceGenerator (name = "seq_autor", sequenceName = "seq_autor_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    
    @NotBlank(message = "o nome deve ser informado")
    @Length(max = 80, message = "O nome não poder mais quqe {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "o nome deve ser informado")
    @Column(name = "bibliografia", nullable = false)
    private String bibliografia;

    
        @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_livroautor", 
            joinColumns = 
                    @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false), 
            inverseJoinColumns = @JoinColumn(name = "livrobasico", referencedColumnName = "isbn", nullable = false))
    private Set<LivroBasico> autorlivro = new HashSet<>();
    /**
     * @return the id
     */
    
        public Autor(){
        
    }
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the bibliografia
     */
    public String getBibliografia() {
        return bibliografia;
    }

    /**
     * @param bibliografia the bibliografia to set
     */
    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
}