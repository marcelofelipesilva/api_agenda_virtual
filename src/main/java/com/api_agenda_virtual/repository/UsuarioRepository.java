package com.api_agenda_virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_agenda_virtual.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
