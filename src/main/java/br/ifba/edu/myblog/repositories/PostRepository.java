package br.ifba.edu.myblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.myblog.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {}
