package br.edu.unichristus.backend.repository;

import br.edu.unichristus.backend.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {

    List<Livro>findByTituloContainingIgnoreCase(String titulo);
}
