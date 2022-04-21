package br.ifba.edu.myblog.dtos;

import java.util.List;

import br.ifba.edu.myblog.models.Usuario;

import java.util.stream.Collectors;

public class UsuarioDto {

	private long id;
	private String nome;
	private String login;
	
	public UsuarioDto(Usuario usuario) {
		this.id    = usuario.getId();
		this.nome  = usuario.getNome();
		this.login = usuario.getLogin();
	}
	
	public UsuarioDto() {
	}
	
	public static List<UsuarioDto> converte(List<Usuario> usuarios) {
		return usuarios.stream().map(usuario -> new UsuarioDto(usuario)).collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
}
