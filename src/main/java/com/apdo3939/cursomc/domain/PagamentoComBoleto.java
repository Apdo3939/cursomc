package com.apdo3939.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.apdo3939.cursomc.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy ")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy ")
	private Date datapagamento;
	
	public PagamentoComBoleto() {
		
	}
	public PagamentoComBoleto(Date dataVencimento, Date dataPagamento,Integer id, EstadoPagamento estado, Pedido pedido) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.datapagamento = dataPagamento;
		// TODO Auto-generated constructor stub
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}
	
}
