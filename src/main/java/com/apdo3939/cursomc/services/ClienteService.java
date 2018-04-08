package com.apdo3939.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apdo3939.cursomc.domain.Cliente;
import com.apdo3939.cursomc.repositories.ClienteRepository;
import com.apdo3939.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrada! Id: "
				+ id + ", Tipo: " + Cliente.class.getName()));
		
	}

}
