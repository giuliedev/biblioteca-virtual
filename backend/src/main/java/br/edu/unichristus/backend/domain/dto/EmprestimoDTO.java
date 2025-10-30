package br.edu.unichristus.backend.domain.dto;
import lombok.Data;
import java.time.LocalDate;
@Data
public class EmprestimoDTO {
    private Long id;
    private Long usuarioId;
    private Long livroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}
