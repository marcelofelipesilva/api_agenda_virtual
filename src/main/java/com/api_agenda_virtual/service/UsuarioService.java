package com.api_agenda_virtual.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.api_agenda_virtual.model.Usuario;
import com.api_agenda_virtual.repository.UsuarioRepository;

public class UsuarioService {

	@Autowired
	private UsuarioRepository usuario;

	public List<Usuario> findAll() {
		return usuario.findAll();
	}

	public <S extends Usuario> S saveAndFlush(S entity) {

		return usuario.saveAndFlush(entity);
	}

	public Usuario getById(Long id) {
		return usuario.getById(id);
	}

	public void deleteById(Long id) {
		usuario.deleteById(id);
	}


}
