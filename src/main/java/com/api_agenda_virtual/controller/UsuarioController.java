package com.api_agenda_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api_agenda_virtual.repository.UsuarioRepository;
import com.api_agenda_virtual.model.*;

@RestController("/usuario")
public class UsuarioController {


	private UsuarioRepository _usuarioRepository;

	public UsuarioController(UsuarioRepository _usuarioRepository) {
		this._usuarioRepository = _usuarioRepository;
	}

	@GetMapping(value = "/usuario", produces = "application/json")
	public List<Usuario> Exibir_Usuarios() {
		return _usuarioRepository.findAll();
	}

	@GetMapping(value = "/usuario/{id}", produces = "application/json")
	public ResponseEntity<Usuario> Exibir_Usuario_Id(@PathVariable(value = "id") long id) {
		java.util.Optional<Usuario> usuario = _usuarioRepository.findById(id);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/usuario", produces = "application/json")
	public <S extends Usuario> S Cadastro_Usuario(S entity) {

		return _usuarioRepository.saveAndFlush(entity);
	}

	
	 @PutMapping(value = "/usuario/{id}", produces="application/json")
	    public ResponseEntity<Usuario> Atualizar_Usuario(@PathVariable(value = "id") long id, @Validated @RequestBody Usuario newUsuario)
	    {
		 java.util.Optional<Usuario> oldUsuario = _usuarioRepository.findById(id);
	        if(oldUsuario.isPresent()){
	        	Usuario usuario = oldUsuario.get();
	        	usuario.setLogin(newUsuario.getLogin());
	        	usuario.setSenha(newUsuario.getSenha());
	            _usuarioRepository.save(usuario);
	            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	@DeleteMapping(value = "/usuario/{id}", produces = "application/json")
	public ResponseEntity<Usuario> Deletar_Usuario(@PathVariable(value = "id") long id) {
		java.util.Optional<Usuario> usuario = _usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			_usuarioRepository.delete(usuario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
