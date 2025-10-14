package br.edu.unichristus.projetoBiblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Multa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private Double valor;
    private String diasAtraso;
    private LocalDate dataGeracao;
    private Boolean pagamentoRealizado;

    private Emprestimo emprestimo;
}
