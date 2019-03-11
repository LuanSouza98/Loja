package br.edu.ucsal.loja.bean;

public class Cliente {

	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	private Endereco endereco;

	public Cliente() {

	}

	public Cliente(Integer id, String nome, String cpf, String telefone, String celular, String email, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
	}

	public Cliente(String nome, String cpf, String telefone, String celular, String email, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", celular="
				+ celular + ", email=" + email + ", endereco=" + endereco + "]";
	}

}
