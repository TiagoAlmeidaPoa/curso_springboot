package com.tiagoalmeida.cursinhomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.cursinhomc.entities.Categoria;
import com.tiagoalmeida.cursinhomc.repositories.CategoriaRepository;
import com.tiagoalmeida.cursinhomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> {
			throw new ObjectNotFoundException("Object not found for " + id + ", Tipo: " + Categoria.class.getName());
		});
	}

}
