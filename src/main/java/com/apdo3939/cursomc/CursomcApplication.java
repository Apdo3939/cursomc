package com.apdo3939.cursomc;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apdo3939.cursomc.domain.Categoria;
import com.apdo3939.cursomc.domain.Produto;
import com.apdo3939.cursomc.repositories.CategoriaRepository;
import com.apdo3939.cursomc.repositories.ProdutoRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(CursomcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		 
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Games");
		Categoria cat4 = new Categoria(null, "Video Games");
		Categoria cat5 = new Categoria(null, "Acessórios");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora",  800.00);
		Produto p3 = new Produto(null,"Mouse",        80.00);
		Produto p4 = new Produto(null,"Xbox one X", 4000.00);
		Produto p5 = new Produto(null,"Halo 5",      100.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p5));
		cat4.getProdutos().addAll(Arrays.asList(p4));
		cat5.getProdutos().addAll(Arrays.asList(p2,p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat5));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3,cat5));
		p4.getCategorias().addAll(Arrays.asList(cat3,cat4));
		p5.getCategorias().addAll(Arrays.asList(cat3,cat4));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5 ));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		
	}
}
