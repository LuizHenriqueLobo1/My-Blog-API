package br.ifba.edu.myblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.myblog.dtos.UsuarioDto;
import br.ifba.edu.myblog.models.Usuario;
import br.ifba.edu.myblog.repositories.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@RequestMapping("/usuarios")
	public List<UsuarioDto> listUsuarios() {
		return UsuarioDto.converte(repository.findAll());
	} 
}
