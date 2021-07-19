package com.api_agenda_virtual.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api_agenda_virtual.model.Contato;
import com.api_agenda_virtual.repository.ContatoRepository;

@Service
@Transactional
public class ContatoService {

	@Autowired
	private ContatoRepository contato;

	public List<Contato> findAll() {
		return contato.findAll();
	}

	public <S extends Contato> S saveAndFlush(S entity) {

		return contato.saveAndFlush(entity);
	}

	public Contato getById(Long id) {
		return contato.getById(id);
	}

	public Contato save(Contato entity) {
		contato.save(entity);
		Long id = entity.getIdContato();
		return contato.getById(id);
		
	}
	
	public void deleteById(Long id) {
		contato.deleteById(id);
	}



}
