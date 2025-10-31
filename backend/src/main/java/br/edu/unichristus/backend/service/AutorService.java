package br.edu.unichristus.backend.service;


import br.edu.unichristus.backend.domain.dto.AutorDTO;
import br.edu.unichristus.backend.domain.dto.AutorLowDTO;
import br.edu.unichristus.backend.domain.model.Autor;
import br.edu.unichristus.backend.exception.ApiException;
import br.edu.unichristus.backend.repository.AutorRepository;
import br.edu.unichristus.backend.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public AutorDTO create(AutorDTO dto){
        if(dto.getName().isBlank()){
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.autor.badrequest",
                    "O nome do autor é obrigatório.");
        }
        if(dto.getName().length() > 100){
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.autor.badrequest",
                    "O limite de caracteres do nome do autor é 100");
        }
        var autor = MapperUtil.parseObject(dto, Autor.class);
        var autorPersist = repository.save(autor);

        return MapperUtil.parseObject(autorPersist, AutorDTO.class);
    }

    public List<AutorLowDTO> getAll(){

        return MapperUtil.parseListObjects
                (repository.findAll(), AutorLowDTO.class);
    }

    public AutorDTO update(AutorDTO dto){
        var autor = MapperUtil.parseObject(dto, Autor.class);
        var autorPersist = repository.save(autor);
        return MapperUtil.parseObject(autorPersist, AutorDTO.class);
    }

    public void deleteAutorById(Long id){
        repository.deleteById(id);
    }

    public AutorLowDTO findUserById(Long id) {
        var autor = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "unichristus.service.autor.notfound",
                        "O autor com o id informado não foi encontrado")
        );

        return MapperUtil.parseObject(autor, AutorLowDTO.class);
    }
}
