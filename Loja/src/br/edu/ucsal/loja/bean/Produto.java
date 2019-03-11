package br.edu.ucsal.loja.bean;

import java.math.BigDecimal;

public class Produto {

	private Integer id;
	private String decricao;
	private BigDecimal preco;

	public Produto() {

	}

	public Produto(String decricao, BigDecimal preco) {
		this.decricao = decricao;
		this.preco = preco;
	}

	public Produto(Integer id, String decricao, BigDecimal preco) {
		this.id = id;
		this.decricao = decricao;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", decricao=" + decricao + ", preco=" + preco + "]";
	}

}
