package br.edu.unichristus.projetoBiblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private Boolean emprestimoAtivo;
    private String observacao;

    private Aluno aluno;
}
