package com.project.Protect.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Protect.entities.Pergunta;
import com.project.Protect.service.PerguntaService;

@RestController
@RequestMapping(value = "/question")
public class PerguntaController {
	
	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping
	public ResponseEntity<List<Pergunta>> getPerguntas() {
		List<Pergunta> lista = perguntaService.getPerguntas();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pergunta> findById(@PathVariable Integer id) {
		Pergunta pergunta = perguntaService.findById(id);
		return ResponseEntity.ok().body(pergunta);
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
	
	@PutMapping("/{id}")
	public ResponseEntity<Pergunta> update(@RequestBody Pergunta pergunta, @PathVariable Integer id)
			throws URISyntaxException {
		perguntaService.update(pergunta, id);
		return ResponseEntity.ok().body(pergunta);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Pergunta> logicalExclusion(@PathVariable(value = "id") int id) {
		Pergunta perg = perguntaService.logiacalExclusion(id);
		return ResponseEntity.ok().body(perg);
	}

}
