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
@Table(name = "tb_pergunta")
@Getter
@Setter
public class Pergunta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "A categoria não pode ser nula")
	private Integer categoria;
	
	@NotNull(message = "O título não pode ser nulo")
	private String titulo;
	
	@NotNull(message = "A pergunta não pode ser nula")
    private String pergunta;
	
	private boolean ativo;

}
