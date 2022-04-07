package br.ifba.edu.myblog.models;

public class Post {

	private Long id;
	private String titulo;
	private String texto;
	private Usuario usuario;
	private Categoria categoria;
	
	public Post(Long id, String titulo, String texto, Usuario usuario, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	public Post() {
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
