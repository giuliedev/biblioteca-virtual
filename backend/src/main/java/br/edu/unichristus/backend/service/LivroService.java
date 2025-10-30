package br.edu.unichristus.backend.service;

import br.edu.unichristus.backend.domain.dto.LivroDTO;
import br.edu.unichristus.backend.domain.dto.LivroLowDTO;
import br.edu.unichristus.backend.domain.model.Livro;
import br.edu.unichristus.backend.exception.ApiException;
import br.edu.unichristus.backend.repository.LivroRepository;
import br.edu.unichristus.backend.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public LivroDTO create(LivroDTO dto) {
        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.livro.badrequest",
                    "O título do livro é obrigatório.");
        }
        if (dto.getAutor() == null || dto.getAutor().isBlank()) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.livro.badrequest",
                    "O autor do livro é obrigatório.");
        }
        if (dto.getCategoria() == null || dto.getCategoria().isBlank()) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.livro.badrequest",
                    "A categoria do livro é obrigatória.");
        }
        if (dto.getAnoPublicacao() == null || dto.getAnoPublicacao() < 1000) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.livro.badrequest",
                    "O ano de publicação deve ser válido.");
        }

        if (dto.getDataAdicionado() == null) {
            dto.setDataAdicionado(LocalDate.now());
        }

        var livro = MapperUtil.parseObject(dto, Livro.class);
        var livroPersist = repository.save(livro);

        return MapperUtil.parseObject(livroPersist, LivroDTO.class);
    }

    public List<LivroLowDTO> getAll() {
        return MapperUtil.parseListObjects(repository.findAll(), LivroLowDTO.class);
    }

    public LivroDTO update(LivroDTO dto) {
        if (!repository.existsById(dto.getId().toString())) {
            throw new ApiException(HttpStatus.NOT_FOUND,
                    "unichristus.service.livro.notfound",
                    "O livro com o ID informado não foi encontrado.");
        }

        var livro = MapperUtil.parseObject(dto, Livro.class);
        var livroPersist = repository.save(livro);
        return MapperUtil.parseObject(livroPersist, LivroDTO.class);
    }

    public void deleteLivroById(Long id) {
        if (!repository.existsById(id.toString())) {
            throw new ApiException(HttpStatus.NOT_FOUND,
                    "unichristus.service.livro.notfound",
                    "O livro com o ID informado não foi encontrado.");
        }
        repository.deleteById(id.toString());
    }

    public LivroLowDTO findLivroById(Long id) {
        var livro = repository.findById(id.toString()).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "unichristus.service.livro.notfound",
                        "O livro com o ID informado não foi encontrado.")
        );
        return MapperUtil.parseObject(livro, LivroLowDTO.class);
    }
}