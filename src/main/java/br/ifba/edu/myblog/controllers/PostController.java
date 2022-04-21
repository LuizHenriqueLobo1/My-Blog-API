package br.ifba.edu.myblog.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.ifba.edu.myblog.models.Post;
import br.ifba.edu.myblog.dtos.PostDto;
import br.ifba.edu.myblog.dtos.PostForm;
import br.ifba.edu.myblog.repositories.PostRepository;
import br.ifba.edu.myblog.repositories.UsuarioRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<PostDto> listPost() {
		return PostDto.converte(this.repository.findAll());
	}
	
	@GetMapping("/{id}")
	public PostDto pegarPostByID(@PathVariable long id) {
		return new PostDto(repository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Post> criar(@RequestBody Post post) {
		repository.save(post);
		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody PostForm postForm) {
		postForm.atualiza(id, repository, usuarioRepository);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
