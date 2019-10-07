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
@Table(name = "tb_formato")
public class Formato implements Serializable{
    
    @Id
    @SequenceGenerator (name = "seq_formato", sequenceName = "seq_formato_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_formato", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    
    @NotBlank(message = "O nome deve ser Informado")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    
    /**
     * @return the id
     */
    
        public Formato(){
        
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
   
}