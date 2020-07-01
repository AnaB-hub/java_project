package com.project.Protect.service;

import java.util.List;

import com.project.Protect.entities.Usuario;

public interface UsuarioService {
	
	public Usuario findById(Integer id);

	Usuario save(Usuario usuario);

	public List<Usuario> getUsuarios();

}
