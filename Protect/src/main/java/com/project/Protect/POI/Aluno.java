package com.project.Protect.POI;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {
	private String nome;
	private String ra;
	private double nota1;
	private double nota2;
	private double media;
	private boolean aprovado;

	public Aluno() {
	}

	public Aluno(String nome, String ra, double nota1, double nota2, double media, boolean aprovado) {
		super();
		this.nome = nome;
		this.ra = ra;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
		this.aprovado = aprovado;
	}
}
