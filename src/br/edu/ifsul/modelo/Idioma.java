/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Julio Cesar
 */
@Entity
@Table(name = "tb_idioma")
public class Idioma implements Serializable{
    
    @Id
    @SequenceGenerator (name = "seq_idioma", sequenceName = "seq_idioma_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_idioma", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    
    @NotBlank(message = "O nome deve ser Informado")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    
    @NotBlank(message = "A sigla deve ser Informada")
    @Length(max = 3, message = "a Sigla não pode ter mais que {max} caracteres")
    @Column(name = "sigla", nullable = false, length = 3)
    private String sigla;

    /**
     * @return the id
     */
    
        public Idioma(){
        
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
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the nome
     */
  
}