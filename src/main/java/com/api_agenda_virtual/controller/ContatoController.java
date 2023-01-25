package com.api_agenda_virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.api_agenda_virtual.model.Contato;
import com.api_agenda_virtual.repository.ContatoRepository;
import com.google.common.base.Optional;

@RestController("/contato")
@Scope("Singleton")
public class ContatoController {


	private ContatoRepository _contatoRepository;

	public ContatoController(ContatoRepository _contatoRepository) {
		this._contatoRepository = _contatoRepository;
	}

	@GetMapping(value = "/contato", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Contato> Exibir_Contatos() {
		return _contatoRepository.findAll();
	}

	@GetMapping(value = "/contato/{id}", produces = "application/json")
	public ResponseEntity<Contato> Exibir_Contato_Id(@PathVariable(value = "id") long id) {
		java.util.Optional<Contato> contato = _contatoRepository.findById(id);
		if (contato.isPresent())
			return new ResponseEntity<Contato>(contato.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/contato", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public <S extends Contato> S Cadastro_Contato(S entity) {

		return _contatoRepository.saveAndFlush(entity);
	}
	
	 @PutMapping(value = "/contato/{id}", produces="application/json")
	    public ResponseEntity<Contato> Atualizar_Contato(@PathVariable(value = "id") long id, @Validated @RequestBody Contato newContato)
	    {
		 java.util.Optional<Contato> oldContato = _contatoRepository.findById(id);
	        if(oldContato.isPresent()){
	        	Contato contato = oldContato.get();
	        	contato.setNome(newContato.getNome());
	        	contato.setEmail(newContato.getEmail());
	        	contato.setTelefone(newContato.getTelefone());
	            _contatoRepository.save(contato);
	            return new ResponseEntity<Contato>(contato, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	 @DeleteMapping(value = "/contato/{id}", produces="application/json")
	    public ResponseEntity<Contato> Deletar_Contato(@PathVariable(value = "id") long id)
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
