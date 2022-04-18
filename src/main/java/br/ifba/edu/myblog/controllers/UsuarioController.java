package br.ifba.edu.myblog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.ifba.edu.myblog.repositories.UsuarioRepository;
import br.ifba.edu.myblog.dtos.UsuarioDto;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/usuarios")
	public List<UsuarioDto> listUsuarios() {
		return UsuarioDto.converte(repository.findAll());
	}

	@GetMapping("/usuarios/{id}")
	public UsuarioDto pegarUsuarioByID(@PathVariable long id) {
		return new UsuarioDto(repository.findById(id));
	}
}
