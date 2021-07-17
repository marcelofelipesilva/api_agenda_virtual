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
import com.api_agenda_virtual.model.Contato;
import com.api_agenda_virtual.repository.ContatoRepository;

@RestController("/contato")
public class ContatoController {

	@Autowired
	private ContatoRepository _contatoRepository;

	@GetMapping(value = "/contato", produces = "application/json")
	public List<Contato> FindAll() {
		return _contatoRepository.findAll();
	}

	@GetMapping(value = "/contato/{id}", produces = "application/json")
	public ResponseEntity<Contato> GetById(@PathVariable(value = "id") long id) {
		java.util.Optional<Contato> contato = _contatoRepository.findById(id);
		if (contato.isPresent())
			return new ResponseEntity<Contato>(contato.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/contato", produces = "application/json")
	public <S extends Contato> S Cadastro_Contato(S entity) {

		return _contatoRepository.saveAndFlush(entity);
	}
	
	 @DeleteMapping(value = "/contato/{id}", produces="application/json")
	    public ResponseEntity<Contato> Delete(@PathVariable(value = "id") long id)
	    {
		 java.util.Optional<Contato> contato = _contatoRepository.findById(id);
	        if(contato.isPresent()){
	            _contatoRepository.delete(contato.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	
	
}
