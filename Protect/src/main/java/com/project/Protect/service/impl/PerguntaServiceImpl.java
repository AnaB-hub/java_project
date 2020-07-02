package com.project.Protect.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
		pergunta.setAtivo(true);
		return perguntaRepository.save(pergunta);
	}

	@Override
	public Stream<Pergunta> findAtivos() {
		List<Pergunta> lista = perguntaRepository.findAll();
		return lista.stream().filter(p -> p.isAtivo() == true);
	}

	@Override
	public Pergunta findById(Integer id) {
		Optional<Pergunta> pergunta = perguntaRepository.findById(id);
		return pergunta.orElse(null);
	}

}
