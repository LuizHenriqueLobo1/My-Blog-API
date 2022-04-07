package br.ifba.edu.myblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.myblog.models.Post;

import br.ifba.edu.myblog.repositories.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@RequestMapping("/posts")
	public List<Post> listPost() {
		return this.repository.findAll();
	}
}
