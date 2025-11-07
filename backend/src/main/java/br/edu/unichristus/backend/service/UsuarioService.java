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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private EmailService mailService;

    public UsuarioDTO create(UsuarioDTO dto) {
        if (dto.getName().isBlank()) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.usuario.badrequest",
                    "O nome do usuário é obrigatório.");
        }

        if (dto.getName().length() > 100) {
            throw new ApiException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.usuario.badrequest",
                    "O limite de caracteres do nome do usuário é 100.");
        }

        var usuario = MapperUtil.parseObject(dto, Usuario.class);
        var usuarioPersist = repository.save(usuario);

        enviarEmailBoasVindas(usuarioPersist);

        return MapperUtil.parseObject(usuarioPersist, UsuarioDTO.class);
    }

    public List<UsuarioLowDTO> getAll() {
        return MapperUtil.parseListObjects(repository.findAll(), UsuarioLowDTO.class);
    }

    public UsuarioDTO update(UsuarioDTO dto) {
        var user = MapperUtil.parseObject(dto, Usuario.class);
        var userPersist = repository.save(user);
        return MapperUtil.parseObject(userPersist, UsuarioDTO.class);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    public UsuarioLowDTO findUserById(Long id) {
        var user = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "unichristus.service.user.notfound",
                        "O usuário com o id informado não foi encontrado")
        );
        return MapperUtil.parseObject(user, UsuarioLowDTO.class);
    }

    private void enviarEmailBoasVindas(Usuario usuarioPersist) {
        if (usuarioPersist.getEmail() != null && !usuarioPersist.getEmail().isBlank()) {
            try {
                mailService.enviarEmailTexto(
                        usuarioPersist.getEmail(),
                        "Novo usuário cadastrado",
                        "Olá " + usuarioPersist.getName() + ",\n\nBem-vindo à Biblioteca Virtual! Seu cadastro foi realizado com sucesso."
                );
            } catch (Exception e) {
                logger.warn("Falha ao enviar email de boas-vindas para o usuário {} ({}): {}",
                        usuarioPersist.getName(), usuarioPersist.getEmail(), e.getMessage());
            }
        }
    }
}
