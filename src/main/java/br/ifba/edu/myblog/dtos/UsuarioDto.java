package br.ifba.edu.myblog.dtos;

import java.util.List;

import br.ifba.edu.myblog.models.Usuario;

import java.util.stream.Collectors;

public class UsuarioDto {

	public long id;
	public String nome;
	public String login;
	
	public UsuarioDto(Usuario usuario) {
		this.id    = usuario.getId();
		this.nome  = usuario.getNome();
		this.login = usuario.getLogin();
	}
	
	public static List<UsuarioDto> converte(List<Usuario> usuarios) {
		return usuarios.stream().map(usuario -> new UsuarioDto(usuario)).collect(Collectors.toList());
	}
}
