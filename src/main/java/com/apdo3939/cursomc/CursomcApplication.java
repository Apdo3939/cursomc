package com.apdo3939.cursomc;

import java.lang.reflect.Array;
import java.util.*;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.apdo3939.cursomc.domain.Categoria;
import com.apdo3939.cursomc.repositories.CategoriaRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(CursomcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		 
		Categoria cata = new Categoria(null, "Informatica");
		Categoria catb = new Categoria(null, "Escritório");
		
		this.categoriaRepository.saveAll(Arrays.asList(cata,catb));

		
	}
}
