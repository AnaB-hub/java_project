package com.project.Protect.service;

import java.util.List;

import com.project.Protect.entities.Usuario;
import java.util.stream.Stream;

public interface UsuarioService {
	
	public Usuario findById(Integer id);

	public Usuario save(Usuario usuario);

	public List<Usuario> getUsuarios();

	public Usuario update(Usuario usuario, Integer id);

	public Stream<Usuario> findAtivos();

	public void logiacalExclusion(Integer id);

}
