package br.edu.unichristus.backend.service;

import br.edu.unichristus.backend.domain.dto.UsuarioDTO;
import br.edu.unichristus.backend.domain.dto.UsuarioLowDTO;
import br.edu.unichristus.backend.domain.model.Usuario;
import br.edu.unichristus.backend.exception.ApiException;
import br.edu.unichristus.backend.repository.UsuarioRepository;
import br.edu.unichristus.backend.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioLowDTO> getAll(){

        return MapperUtil.parseListObjects
                (repository.findAll(), UsuarioLowDTO.class);
    }

    public UsuarioDTO update(UsuarioDTO dto){
        var user = MapperUtil.parseObject(dto, Usuario.class);
        var userPersist = repository.save(user);
        return MapperUtil.parseObject(userPersist, UsuarioDTO.class);
    }

    public void deleteUserById(Long id){
        repository.deleteById(id);
    }

    public UsuarioLowDTO findUserById(Long id){
        var user = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "unichristus.service.user.notfound",
                        "O usuário com o id informado não foi encontrado")
        );
        return MapperUtil.parseObject(user, UsuarioLowDTO.class);
    }





}
