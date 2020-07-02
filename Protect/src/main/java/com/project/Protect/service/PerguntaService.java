package com.project.Protect.service;

import java.util.List;
import java.util.stream.Stream;

import com.project.Protect.entities.Pergunta;

public interface PerguntaService {

	List<Pergunta> getPerguntas();

	Pergunta save(Pergunta pergunta);

	Stream<Pergunta> findAtivos();

}
