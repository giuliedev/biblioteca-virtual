package br.edu.unichristus.backend.domain.dto;

import lombok.Data;
import java.util.Date;

@Data
public class AutorDTO {

    private Long id;
    private String name;
    private Date dataNascimento;
    private String obrasPublicadas;
    private String generoLiterario;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getObrasPublicadas() {
        return obrasPublicadas;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public void setObrasPublicadas(String obrasPublicadas) {
        this.obrasPublicadas = obrasPublicadas;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}