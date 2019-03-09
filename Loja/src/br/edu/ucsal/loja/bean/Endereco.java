package br.edu.ucsal.loja.bean;

public class Endereco {

	private Integer id;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String cep;

	public Endereco(String cidade, String bairro, String rua, String numero, String cep) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", cep="
				+ cep + "]";
	}

}
