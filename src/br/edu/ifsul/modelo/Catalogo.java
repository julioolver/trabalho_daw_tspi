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
import javax.persistence.JoinColumn;
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
@Table(name = "tb_catalogo")
public class Catalogo implements Serializable{
    
    @Id
    @SequenceGenerator (name = "seq_catalogo", sequenceName = "seq_catalogo_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    
    @NotBlank(message = "o nome deve ser informado")
    @Length(max = 50, message = "O nome não poder mais quqe {max} caracteres")
    @Column(name = "nome", nullable = false, length = 25)
    private String nome;
    
    @NotBlank(message = "A Descrição deve ser Informada")
    @Length(max = 100, message = "A Descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "livraria", referencedColumnName = "id", nullable = false)
    private Livraria livraria;

    /**
     * @return the id
     */
    
        public Catalogo(){
        
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the livraria
     */
    public Livraria getLivraria() {
        return livraria;
    }

    /**
     * @param livraria the livraria to set
     */
    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }

}