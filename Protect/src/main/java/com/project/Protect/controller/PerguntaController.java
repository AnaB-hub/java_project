package com.project.Protect.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Protect.entities.Pergunta;
import com.project.Protect.entities.Usuario;
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
	
	@GetMapping("/ativos")
	public Stream<Pergunta> ativos() {
		return perguntaService.findAtivos();
	}
	
	@PostMapping
	public ResponseEntity<Pergunta> save(@RequestBody Pergunta pergunta) throws URISyntaxException {
		Pergunta perg = perguntaService.save(pergunta);
		return ResponseEntity.created(new URI(("/pergunta/salvar/" + perg.getId()))).body(perg);
	}

}
