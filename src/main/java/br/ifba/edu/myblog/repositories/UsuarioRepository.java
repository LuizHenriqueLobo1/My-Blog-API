package br.ifba.edu.myblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.myblog.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findById(long id);
} 
