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

import com.project.Protect.entities.Categoria;
import com.project.Protect.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategorias() {
		List<Categoria> lista = categoriaService.getCategorias();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping("/ativos")
	public Stream<Categoria> ativos() {
		return categoriaService.findAtivos();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) throws URISyntaxException {
		Categoria cat = categoriaService.save(categoria);
		return ResponseEntity.created(new URI(("/categoria/salvar/" + cat.getId()))).body(cat);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer id)
			throws URISyntaxException {
		categoriaService.update(categoria, id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Categoria> logicalExclusion(@PathVariable(value = "id") int id) {
		Categoria cat = categoriaService.logiacalExclusion(id);
		return ResponseEntity.ok().body(cat);
	}

}
