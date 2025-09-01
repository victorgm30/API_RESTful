package com.moreira.trabalhorestful.model;

import java.util.Objects;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da tarefa é obrigatório")
    private String nome;

    @NotNull(message = "Data de entrega é obrigatória")
    private LocalDate dataEntrega;

    @NotBlank(message = "Responsável é obrigatório")
    private String responsavel;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    // toString()
    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", nome=" + nome + ", dataEntrega=" + dataEntrega + ", responsavel=" + responsavel + "]";
    }

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataEntrega, responsavel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarefa other = (Tarefa) obj;
        return Objects.equals(id, other.id) &&
               Objects.equals(nome, other.nome) &&
               Objects.equals(dataEntrega, other.dataEntrega) &&
               Objects.equals(responsavel, other.responsavel);
    }
}