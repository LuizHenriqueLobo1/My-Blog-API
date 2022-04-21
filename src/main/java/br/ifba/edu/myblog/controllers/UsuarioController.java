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

import br.ifba.edu.myblog.models.Usuario;
import br.ifba.edu.myblog.dtos.UsuarioDto;
import br.ifba.edu.myblog.dtos.UsuarioForm;
import br.ifba.edu.myblog.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public List<UsuarioDto> listUsuarios() {
		return UsuarioDto.converte(repository.findAll());
	}

	@GetMapping("/{id}")
	public UsuarioDto pegarUsuarioByID(@PathVariable long id) {
		return new UsuarioDto(repository.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postarUsuario(@RequestBody Usuario usuario) {
		repository.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody UsuarioForm usuarioForm) {
		usuarioForm.atualiza(id, repository);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
