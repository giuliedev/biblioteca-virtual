package br.edu.unichristus.backend.service;

import br.edu.unichristus.backend.domain.dto.CategoriaDTO;
import br.edu.unichristus.backend.domain.dto.CategoriaLowDTO;
import br.edu.unichristus.backend.domain.model.Categoria;
import br.edu.unichristus.backend.exception.ApiException;
import br.edu.unichristus.backend.repository.CategoriaRepository;
import br.edu.unichristus.backend.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    public CategoriaDTO create(CategoriaDTO dto) {
        var categoria = MapperUtil.parseObject(dto, Categoria.class);
        var categoriaPersist = repository.save(categoria);
        return MapperUtil.parseObject(categoriaPersist, CategoriaDTO.class);
    }

    public List<CategoriaLowDTO> getAll() {
        return MapperUtil.parseListObjects(repository.findAll(), CategoriaLowDTO.class);
    }

    public CategoriaDTO update(CategoriaDTO dto) {
        var categoria = MapperUtil.parseObject(dto, Categoria.class);
        var categoriaPersist = repository.save(categoria);
        return MapperUtil.parseObject(categoriaPersist, CategoriaDTO.class);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public CategoriaLowDTO findById(Long id) {
        var categoria = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "unichristus.service.categoria.notfound",
                        "A categoria com o ID informado não foi encontrada.")
        );
        return MapperUtil.parseObject(categoria, CategoriaLowDTO.class);
    }
}

