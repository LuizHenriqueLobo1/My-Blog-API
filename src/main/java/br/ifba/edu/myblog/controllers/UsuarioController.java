package br.ifba.edu.myblog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.ifba.edu.myblog.repositories.UsuarioRepository;
import br.ifba.edu.myblog.dtos.UsuarioDto;
import br.ifba.edu.myblog.models.Usuario;

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
}
