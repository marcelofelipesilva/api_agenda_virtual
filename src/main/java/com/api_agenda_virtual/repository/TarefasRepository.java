package com.api_agenda_virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_agenda_virtual.model.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long > {

}
