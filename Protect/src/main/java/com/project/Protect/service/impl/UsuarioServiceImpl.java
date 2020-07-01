package com.project.Protect.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Protect.entities.Usuario;
import com.project.Protect.repositories.UsuarioRepository;
import com.project.Protect.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario findById(Integer id) {
		Optional<Usuario> curso = usuarioRepository.findById(id);
		return curso.orElse(null);
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		usuario.setAtivo(true);
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario update(Usuario usuario, Integer id) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}

	@Override
	public Stream<Usuario> findAtivos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().filter(p -> p.isAtivo() == true);
	}

	@Override
	public void logiacalExclusion(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		Usuario user = usuario.orElse(null);
		if (user != null) {
			user.setAtivo(false);
			usuarioRepository.save(user);			
		}
	}

}
