/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Julio Cesar
 */
@Entity

@Table(name = "acesso_usuario")
public class AcessoUsuario implements Serializable {

    @Id

    @Column(name = "id")

    @SequenceGenerator(name = "seq_acesso", sequenceName = "gen_acesso_usuario",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")

    private Integer id;
    @NotNull(message = "A data de acesso deve ser informada")

    @Column(name = "data", nullable = false)

    @Temporal(TemporalType.TIMESTAMP)

    private Calendar data;
    @NotNull(message = "O usuário deve ser informado")

    @ManyToOne

    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)

    private Usuario usuario;
    @NotEmpty(message = "O IP de acesso deve ser informado")

    @Length(max = 15, message = "O IP de acesso não pode ter mais de {max} caracteres")

    @Column(name = "ip_acesso", length = 15, nullable = false)

    private String ipAcesso;

    
public AcessoUsuario(String ipAcesso) {
        this.data = Calendar.getInstance();
        this.ipAcesso = ipAcesso;
       }
}
