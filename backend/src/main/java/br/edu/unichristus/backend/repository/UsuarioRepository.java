package br.edu.unichristus.backend.repository;

import br.edu.unichristus.backend.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
