package com.apdo3939.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apdo3939.cursomc.domain.Categoria;
import com.apdo3939.cursomc.repositories.CategoriaRepository;
import com.apdo3939.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: "
				+ id + ", Tipo: " + Categoria.class.getName()));
		
	}

}
