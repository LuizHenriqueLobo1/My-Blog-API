package br.ifba.edu.myblog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.ifba.edu.myblog.repositories.PostRepository;
import br.ifba.edu.myblog.dtos.PostDto;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@GetMapping("/posts")
	public List<PostDto> listPost() {
		return PostDto.converte(this.repository.findAll());
	}
	
	@GetMapping("/posts/{id}")
	public PostDto pegarPostByID(@PathVariable long id) {
		return new PostDto(repository.findById(id));
	}	
}
