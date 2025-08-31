package com.moreira.trabalhorestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moreira.trabalhorestfull.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}