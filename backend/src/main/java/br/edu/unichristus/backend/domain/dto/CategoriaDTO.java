package br.edu.unichristus.backend.domain.dto;
import lombok.Data;
@Data
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String idioma;
    private String publicoAlvo;
    private Integer quantidadeLivros;
}
