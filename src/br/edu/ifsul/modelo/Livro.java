/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Julio Cesar
 */
@Entity
@Table(name = "tb_livro")
@Inheritance(strategy = InheritanceType.JOINED)

public class Livro extends LivroBasico implements Serializable{
    
    @NotBlank(message = "O Código de Barras deve ser Informado")
    @Length(max = 16, message = "O Código de Barras não pode ter mais que {max} caracteres")
    @Column(name = "codigobarras", nullable = false, length = 16)
    private String codigobarras;
    
    @Min(value= 0, message = "a quantidade não pode ser negativa")
    @NotNull(message = "O número de páginas deve ser informado")
    @Column(name = "numeropaginas", nullable = false, length = 10)
    private Integer numeropaginas;
    
     @NotNull(message = "Esolha se o Livro está Ativo")
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    
    @NotNull(message = "Informe a data de Cadastro")
     @Temporal(TemporalType.DATE)
    @Column(name = "datacadastro", nullable = false)
    private Calendar datacadastro;
    
    @Min(value= 0, message = "o preco não pode ser negativo")
    @NotNull(message = "o preco deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(10,2)")
    private double valor;
    
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    private Idioma idioma;
    
        @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    private Formato formato;

        public Livro(){
        
    }

    /**
     * @return the CodigoBarras
     */
   

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the codigobarras
     */
    public String getCodigobarras() {
        return codigobarras;
    }

    /**
     * @param codigobarras the codigobarras to set
     */
    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    /**
     * @return the numeropaginas
     */
    public Integer getNumeropaginas() {
        return numeropaginas;
    }

    /**
     * @param numeropaginas the numeropaginas to set
     */
    public void setNumeropaginas(Integer numeropaginas) {
        this.numeropaginas = numeropaginas;
    }

    /**
     * @return the datacadastro
     */
    public Calendar getDatacadastro() {
        return datacadastro;
    }

    /**
     * @param datacadastro the datacadastro to set
     */
    public void setDatacadastro(Calendar datacadastro) {
        this.datacadastro = datacadastro;
    }

    /**
     * @return the idioma
     */
    public Idioma getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the formato
     */
    public Formato getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(Formato formato) {
        this.formato = formato;
    }
 

}