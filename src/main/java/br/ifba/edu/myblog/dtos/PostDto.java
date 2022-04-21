package br.ifba.edu.myblog.dtos;

import java.util.List;

import br.ifba.edu.myblog.models.Categoria;
import br.ifba.edu.myblog.models.Post;

import java.util.stream.Collectors;

public class PostDto {

	private Long id;
	private String titulo;
	private String texto;
	private Categoria categoria;
	private UsuarioDto usuario;
	
	public PostDto(Post post) {
		this.id 	   = post.getId();
		this.titulo    = post.getTitulo();
		this.texto     = post.getTexto();
		this.categoria = post.getCategoria();
		this.usuario   = new UsuarioDto(post.getUsuario());
	}
	
	public PostDto() {
	}
	
	public static List<PostDto> converte(List<Post> posts) {
		return posts.stream().map(post -> new PostDto(post)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
}
