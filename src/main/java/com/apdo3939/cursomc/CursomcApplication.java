package com.apdo3939.cursomc;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apdo3939.cursomc.domain.Categoria;
import com.apdo3939.cursomc.domain.Cidade;
import com.apdo3939.cursomc.domain.Estado;
import com.apdo3939.cursomc.domain.Produto;
import com.apdo3939.cursomc.repositories.CategoriaRepository;
import com.apdo3939.cursomc.repositories.CidadeRepository;
import com.apdo3939.cursomc.repositories.EstadoRepository;
import com.apdo3939.cursomc.repositories.ProdutoRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	
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
		
		
		Estado est1 = new Estado(null,"Rio de Janeiro");
		Estado est2 = new Estado(null,"São paulo");
		Estado est3 = new Estado(null,"Espírito Santo");
		Estado est4 = new Estado(null,"Goias");
		Estado est5 = new Estado(null,"Minas Gerais");
		
		Cidade cid1 = new Cidade(null, "Rio de Janeiro",est1);
		Cidade cid2 = new Cidade(null, "Niteroi",est1);
		Cidade cid3 = new Cidade(null, "São Paulo",est2);
		Cidade cid4 = new Cidade(null, "Campinas",est2);
		Cidade cid5 = new Cidade(null, "Cariacica",est3);
		Cidade cid6 = new Cidade(null, "Vitória",est3);
		Cidade cid7 = new Cidade(null, "Goiana",est4);
		Cidade cid8 = new Cidade(null, "Juiz de Fora",est5);
		
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3,est4,est5));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3,cid4,cid5,cid6,cid7,cid8));
		

		
	}
}
