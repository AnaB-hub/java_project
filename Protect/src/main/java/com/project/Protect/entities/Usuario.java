package com.project.Protect.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O nome não pode ser nulo")
	private String nome;
	
	@NotNull(message = "O CPF não pode ser nulo")
	private String cpf;
	
	@NotNull(message = "A senha não pode ser nula")
	private String senha;
	
	private String email;
	
	private boolean ativo = true;

}
