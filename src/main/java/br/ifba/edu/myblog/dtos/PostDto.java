package br.ifba.edu.myblog.dtos;

import java.util.List;

import br.ifba.edu.myblog.models.Categoria;
import br.ifba.edu.myblog.models.Post;

import java.util.stream.Collectors;

public class PostDto {

	public Long id;
	public String titulo;
	public String texto;
	public Categoria categoria;
	
	public PostDto(Post post) {
		this.id 	   = post.getId();
		this.titulo    = post.getTitulo();
		this.texto     = post.getTexto();
		this.categoria = post.getCategoria();
	}
	
	public static List<PostDto> converte(List<Post> posts) {
		return posts.stream().map(post -> new PostDto(post)).collect(Collectors.toList());
	}
}
