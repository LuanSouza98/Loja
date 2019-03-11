package br.edu.ucsal.loja.bean;

public class Usuario {

	private Integer id;
	private String nome;
	private String login;
	private String senha;

	public Usuario() {

	}

	public Usuario(Integer id, String nome, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	private static class UsuarioLogado {
		private final static Usuario instance = new Usuario();
	}

	public static Usuario getUsuarioLogado() {
		return UsuarioLogado.instance;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.id = usuarioLogado.getId();
		this.nome = usuarioLogado.getNome();
		this.login = usuarioLogado.getLogin();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}

}
