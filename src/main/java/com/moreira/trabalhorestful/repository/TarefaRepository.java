package com.moreira.trabalhorestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moreira.trabalhorestful.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}