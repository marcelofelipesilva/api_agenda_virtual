package com.api_agenda_virtual.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.api_agenda_virtual.model.Contato;
import com.api_agenda_virtual.model.Tarefas;
import com.api_agenda_virtual.repository.TarefasRepository;

public class TarefasService {


	private TarefasRepository tarefas;

	public TarefasService(TarefasRepository tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefas> findAll() {
		return tarefas.findAll();
	}

	public <S extends Tarefas> S saveAndFlush(S entity) {

		return tarefas.saveAndFlush(entity);
	}

	public Tarefas getById(Long id) {
		return tarefas.getById(id);
	}

	public Tarefas save(Tarefas entity) {
		tarefas.save(entity);
		Long id = entity.getIdTarefa();
		return tarefas.getById(id);
		
	}
	
	
	public void deleteById(Long id) {
		tarefas.deleteById(id);
	}


}
