package com.api_agenda_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_agenda_virtual.model.*;
import com.api_agenda_virtual.repository.*;

@RestController("/tarefas")
public class TarefasController {

	@Autowired
	private TarefasRepository _tarefasRepository;

	@GetMapping(value = "/tarefas", produces = "application/json")
	public List<Tarefas> FindAll() {
		return _tarefasRepository.findAll();
	}

	@GetMapping(value = "/tarefas/{id}", produces = "application/json")
	public ResponseEntity<Tarefas> GetById(@PathVariable(value = "id") long id) {
		java.util.Optional<Tarefas> tarefas = _tarefasRepository.findById(id);
		if (tarefas.isPresent())
			return new ResponseEntity<Tarefas>(tarefas.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/tarefas", produces = "application/json")
	public <S extends Tarefas> S Cadastro_Tarefas(S entity) {

		return _tarefasRepository.saveAndFlush(entity);
	}

	@DeleteMapping(value = "/tarefas/{id}", produces = "application/json")
	public ResponseEntity<Tarefas> Delete(@PathVariable(value = "id") long id) {
		java.util.Optional<Tarefas> tarefas = _tarefasRepository.findById(id);
		if (tarefas.isPresent()) {
			_tarefasRepository.delete(tarefas.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
