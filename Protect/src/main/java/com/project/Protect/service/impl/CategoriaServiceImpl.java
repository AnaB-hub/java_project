package com.project.Protect.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Protect.entities.Categoria;
import com.project.Protect.repositories.CategoriaRepository;
import com.project.Protect.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired 
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria save(Categoria categoria) {
		categoria.setAtivo(true);
		return categoriaRepository.save(categoria);
	}

	@Override
	public Stream<Categoria> findAtivos() {
		List<Categoria> lista = categoriaRepository.findAll();
		return lista.stream().filter(p -> p.isAtivo() == true);
	}

	@Override
	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElse(null);
	}

	@Override
	public Categoria update(Categoria categoria, Integer id) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria logiacalExclusion(int id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		Categoria cat = categoria.orElse(null);
		Categoria nova = null;
		if (cat != null) {
			cat.setAtivo(false);
			nova = categoriaRepository.save(cat);			
		}
		return nova;
	}

}
