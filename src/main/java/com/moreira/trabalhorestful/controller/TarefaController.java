package com.moreira.trabalhorestful.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moreira.trabalhorestful.model.Tarefa;
import com.moreira.trabalhorestful.repository.TarefaRepository;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    private final TarefaRepository tarefaRepository;

    // Injeção de dependência via construtor
    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // Criar tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa) {
        Tarefa nova = tarefaRepository.save(tarefa);
        return ResponseEntity.status(201).body(nova); // HTTP 201 Created
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return ResponseEntity.ok(tarefas);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa dados) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setNome(dados.getNome());
            tarefa.setDataEntrega(dados.getDataEntrega());
            tarefa.setResponsavel(dados.getResponsavel());
            Tarefa atualizado = tarefaRepository.save(tarefa);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build(); // HTTP 204 No Content
        }).orElse(ResponseEntity.notFound().build());
    }
}