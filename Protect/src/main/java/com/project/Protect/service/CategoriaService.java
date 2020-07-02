package com.project.Protect.service;

import java.util.List;
import java.util.stream.Stream;

import com.project.Protect.entities.Categoria;

public interface CategoriaService {
	
	List<Categoria> getCategorias();

	Categoria save(Categoria categoria);

	Stream<Categoria> findAtivos();

	Categoria findById(Integer id);

	Categoria update(Categoria categoria, Integer id);

	Categoria logiacalExclusion(int id);

}
