package br.ifba.edu.myblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.myblog.repositories.PostRepository;
import br.ifba.edu.myblog.dtos.PostDto;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@RequestMapping("/posts")
	public List<PostDto> listPost() {
		return PostDto.converte(this.repository.findAll());
	}
}
