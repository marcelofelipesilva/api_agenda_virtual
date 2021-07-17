package com.api_agenda_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_agenda_virtual.model.*;
import com.api_agenda_virtual.repository.*;

@RestController("/tarefas")
public class TarefasController {
	
	@Autowired
	private TarefasRepository _tarefasRepository;
	
	@GetMapping(value="/tarefas" , produces = "application/json")
	  public List<Tarefas> Get() {
        return _tarefasRepository.findAll();
    }

	@PostMapping(value="/tarefas", produces = "application/json")
	public <S extends Tarefas> S Cadastro_Tarefas(S entity) {

		return _tarefasRepository.saveAndFlush(entity);
	}

}
