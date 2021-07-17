package com.api_agenda_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_agenda_virtual.repository.UsuarioRepository;
import com.api_agenda_virtual.model.*;

@RestController("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository _usuarioRepository;
	
	@GetMapping(value="/usuario" , produces = "application/json")
	  public List<Usuario> Get() {
        return _usuarioRepository.findAll();
    }

	@PostMapping(value = "/usuario", produces = "application/json")
	public <S extends Usuario> S Cadastro_Usuario(S entity) {

		return _usuarioRepository.saveAndFlush(entity);
	}
	

}
