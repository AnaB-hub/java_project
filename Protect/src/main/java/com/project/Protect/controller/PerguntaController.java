package com.project.Protect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Protect.entities.Pergunta;
import com.project.Protect.service.PerguntaService;

@RestController
@RequestMapping(value = "/pergunta")
public class PerguntaController {
	
	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping
	public ResponseEntity<List<Pergunta>> getPerguntas() {
		List<Pergunta> lista = perguntaService.getPerguntas();
		return ResponseEntity.ok().body(lista);
	}

}
