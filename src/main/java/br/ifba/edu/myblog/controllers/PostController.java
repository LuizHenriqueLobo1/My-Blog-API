package br.ifba.edu.myblog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.myblog.models.Post;

@RestController
public class PostController {

	@RequestMapping("/posts")
	public Post listPost() {
		Post post = new Post();
		post.setTitulo("Um título qualquer...");
		return post;
	}
}
