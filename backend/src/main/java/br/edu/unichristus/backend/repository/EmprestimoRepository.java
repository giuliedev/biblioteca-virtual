package br.edu.unichristus.backend.repository;

import br.edu.unichristus.backend.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
}
