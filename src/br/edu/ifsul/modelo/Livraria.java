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
@Table(name = "tb_livraria")
public class Livraria implements Serializable{
    
    @Id
    @SequenceGenerator (name = "seq_livraria", sequenceName = "seq_livraria_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_livraria", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    
    @NotBlank(message = "O nome deve ser Informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "O site deve ser Informado")
    @Length(max = 60, message = "O site não pode ter mais que {max} caracteres")
    @Column(name = "site", nullable = false, length = 60)
    private String site;

    /**
     * @return the id
     */
    
        public Livraria(){
        
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
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }
}