package com.apdo3939.cursomc;



import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apdo3939.cursomc.domain.Categoria;
import com.apdo3939.cursomc.domain.Cidade;
import com.apdo3939.cursomc.domain.Cliente;
import com.apdo3939.cursomc.domain.Endereco;
import com.apdo3939.cursomc.domain.Estado;
import com.apdo3939.cursomc.domain.ItemPedido;
import com.apdo3939.cursomc.domain.Pagamento;
import com.apdo3939.cursomc.domain.PagamentoComBoleto;
import com.apdo3939.cursomc.domain.PagamentoComCartao;
import com.apdo3939.cursomc.domain.Pedido;
import com.apdo3939.cursomc.domain.Produto;
import com.apdo3939.cursomc.domain.enuns.EstadoPagamento;
import com.apdo3939.cursomc.domain.enuns.TipoCliente;
import com.apdo3939.cursomc.repositories.CategoriaRepository;
import com.apdo3939.cursomc.repositories.CidadeRepository;
import com.apdo3939.cursomc.repositories.ClienteRepository;
import com.apdo3939.cursomc.repositories.EnderecoRepository;
import com.apdo3939.cursomc.repositories.EstadoRepository;
import com.apdo3939.cursomc.repositories.ItemPedidoRepository;
import com.apdo3939.cursomc.repositories.PagamentoRepository;
import com.apdo3939.cursomc.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		Cliente cli1 = new Cliente(null, "Maria Theresa", "MTheresa@hotmail.com", "000.000.000-00", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("31568881","999000000"));
		Endereco e1 = new Endereco(null, "Rua A", "1","Flores", "Santa Cruz", "20000-000", cli1, cid1);
		Endereco e2 = new Endereco(null, "Rua B", "10","Margaridas", "Campo Belo", "25000-100", cli1, cid8);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null, sdf.parse("27/09/2017 12:17"),cli1,e2);

		Pagamento pag1 = new PagamentoComCartao(6,null,EstadoPagamento.QUITADO,ped1);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(sdf.parse("20/10/2017 17:00"),null ,null,EstadoPagamento.PENDENTE,ped2);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped2,p4,500.00,2,4000.00);
		ItemPedido ip3 = new ItemPedido(ped1,p3,10.00,5,80.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip3));
		ped2.getItens().addAll(Arrays.asList(ip2));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p3.getItens().addAll(Arrays.asList(ip3));
		p4.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}
}
