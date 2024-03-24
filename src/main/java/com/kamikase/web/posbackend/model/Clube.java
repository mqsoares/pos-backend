package com.kamikase.web.posbackend.model;

import com.kamikase.web.posbackend.validator.EmailValidation;
import com.kamikase.web.posbackend.validator.NomeClubeValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;


@Getter
@Setter
@Entity
@Table(name = "tbl_clube")
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NomeClubeValidation
    @NotEmpty(message = "Nome é obrigatório!")
    private String nome;

    @NotEmpty(message = "Estado é obrigatório!")
    private String estado;

    @Email
    @EmailValidation
    @NotEmpty(message = "Email é obrigatório!")
    private String email;

    @CNPJ
    @NotEmpty(message = "CNPJ é obrigatório!")
    private String cnpj;

    @NotEmpty(message = "Data da criação é obrigatório!")
    private String dataCriacao;

}