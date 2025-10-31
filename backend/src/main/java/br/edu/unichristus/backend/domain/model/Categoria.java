package br.edu.unichristus.backend.domain.model;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    private String idioma;
    private String publicoAlvo;

    @Column(name = "quantiade_livros")
    private Integer quantidadeLivros;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getIdioma(){
        return idioma;
    }
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }

    public String getPublicoAlvo(){
        return publicoAlvo;
    }
    public void setPublicoAlvo(String publicoAlvo){
        this.publicoAlvo = publicoAlvo;
    }
    public Integer getQuantidadeLivros(){
        return quantidadeLivros;
    }
    public void setQuantidadeLivros(Integer quantidadeLivros){
        this.quantidadeLivros = quantidadeLivros;
    }
}
