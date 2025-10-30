package br.edu.unichristus.backend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = 'tb_emprestimo')
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private Long livroId;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;
    private Long alunoId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getAlunoId() { return usuarioId; }

    public void setAlunoId(Long alunoId) { this.usuarioId = usuarioId; }

    public Long getLivroId() { return livroId; }

    public void setLivroId(Long livroId) { this.livroId = livroId; }

    public LocalDate getDataEmprestimo() { return dataEmprestimo; }

    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }

    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

}