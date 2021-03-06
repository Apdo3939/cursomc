package com.apdo3939.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apdo3939.cursomc.domain.Pedido;
import com.apdo3939.cursomc.repositories.PedidoRepository;
import com.apdo3939.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		return  obj.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrad0! Id: "
				+ id + ", Tipo: " + Pedido.class.getName()));
		
	}

}
