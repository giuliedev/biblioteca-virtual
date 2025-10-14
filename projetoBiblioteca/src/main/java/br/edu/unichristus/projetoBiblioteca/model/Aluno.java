package br.edu.unichristus.projetoBiblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Aluno {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    private String nomeAluno;
    private String matricula;
    private LocalDateTime dataNascimento;
    private String telefone;
    private String email;
}
