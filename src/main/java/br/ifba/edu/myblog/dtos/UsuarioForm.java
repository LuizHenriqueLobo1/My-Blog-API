package br.ifba.edu.myblog.dtos;

import br.ifba.edu.myblog.models.Usuario;
import br.ifba.edu.myblog.repositories.UsuarioRepository;

public class UsuarioForm {

	private Long id;
	private String nome;
	private String login;
	private String senha;
	
	public UsuarioForm(Usuario usuario) {
		this.id    = usuario.getId();
		this.nome  = usuario.getNome();
		this.login = usuario.getLogin();
	}
	
	public UsuarioForm() {
	}

	public Usuario atualiza(Long id, UsuarioRepository repository) {
		Usuario usuario = new Usuario();
		usuario.setId(this.id);
		usuario.setNome(this.nome);
		usuario.setLogin(this.login);
		usuario.setSenha(this.senha);
		return usuario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}
