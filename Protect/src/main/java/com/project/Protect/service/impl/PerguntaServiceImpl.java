package com.project.Protect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Protect.entities.Pergunta;
import com.project.Protect.repositories.PerguntaRepository;
import com.project.Protect.service.PerguntaService;

@Service
public class PerguntaServiceImpl implements PerguntaService {
	
	@Autowired
	private PerguntaRepository perguntaRepository;

	@Override
	public List<Pergunta> getPerguntas() {
		return perguntaRepository.findAll();
	}

	@Override
	public Pergunta save(Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
	}

}
