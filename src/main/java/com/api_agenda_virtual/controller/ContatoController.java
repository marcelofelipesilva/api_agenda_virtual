package com.api_agenda_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api_agenda_virtual.model.Contato;
import com.api_agenda_virtual.repository.ContatoRepository;

@RestController("/contato")
public class ContatoController {

	@Autowired
	private ContatoRepository _contatoRepository;

	@GetMapping(value = "/contato", produces = "application/json")
	public List<Contato> findAll() {
		return _contatoRepository.findAll();
	}

	@PostMapping(value = "/contato", produces = "application/json")
	public <S extends Contato> S Cadastro_Contato(S entity) {

		return _contatoRepository.saveAndFlush(entity);
	}

}
