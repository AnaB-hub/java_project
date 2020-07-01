package com.project.Protect.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Protect.entities.Usuario;
import com.project.Protect.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> saveCurso(@RequestBody Usuario user) throws URISyntaxException {
		Usuario novo = usuarioService.save(user);
		return ResponseEntity.created(new URI(("/usuario/salvar/" + novo.getId()))).body(novo);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> lista = usuarioService.getUsuarios();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}

}
