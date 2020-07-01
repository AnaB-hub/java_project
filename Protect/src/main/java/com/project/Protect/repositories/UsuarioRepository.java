package com.project.Protect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Protect.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
