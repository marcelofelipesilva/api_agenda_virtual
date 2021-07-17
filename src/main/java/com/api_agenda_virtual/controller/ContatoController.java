package com.api_agenda_virtual.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/contato")
public class ContatoController {
	
	@RequestMapping(value="/contato", method = RequestMethod.GET)
	public String GetContato() {
		return "Pagina Contato";
	}

}
