package br.ifba.edu.myblog.dtos;

import br.ifba.edu.myblog.models.Categoria;
import br.ifba.edu.myblog.models.Post;
import br.ifba.edu.myblog.repositories.PostRepository;
import br.ifba.edu.myblog.repositories.UsuarioRepository;

public class PostForm {

	private Long id;
	private String titulo;
	private String texto;
	private Categoria categoria;
	private Long usuario;
	
	public PostForm(Post post) {
		this.id 	   = post.getId();
		this.titulo    = post.getTitulo();
		this.texto     = post.getTexto();
		this.categoria = post.getCategoria();
		this.usuario   = post.getUsuario().getId();
	}
	
	public PostForm() {
	}
	
	public Post atualiza(long id, PostRepository postRepository, UsuarioRepository usuarioRepository) {
		Post post = new Post();
		post.setId(this.id);
		post.setTitulo(this.titulo);
		post.setTexto(this.texto);
		post.setCategoria(this.categoria);
		post.setUsuario(usuarioRepository.getById(usuario));
		return post;
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
}
