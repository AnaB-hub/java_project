package com.project.Protect.service;

import java.util.List;

import com.project.Protect.entities.Pergunta;

public interface PerguntaService {

	List<Pergunta> getPerguntas();

	Pergunta save(Pergunta pergunta);

}
