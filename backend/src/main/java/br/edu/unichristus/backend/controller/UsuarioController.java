package br.edu.unichristus.backend.controller;

import br.edu.unichristus.backend.domain.dto.ErrorDTO;
import br.edu.unichristus.backend.domain.dto.UsuarioDTO;
import br.edu.unichristus.backend.domain.dto.UsuarioLowDTO;
import br.edu.unichristus.backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Operation(summary = "Cadastra dados referentes ao usuário",
                   tags = "User")
    @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- O login informado já existe" +
            "\n- O nome do usuário excede o limite de 100 caracteres.")
    @PostMapping
    public UsuarioDTO create(@RequestBody UsuarioDTO user){
        return service.create(user);
    }

    @Operation(summary = "Retorna todos os usuários cadastrados",
            tags = "User")
    @ApiResponse(responseCode = "200", description = "Listagem de usuários retornada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Nenhum dado encontrado, não foi possivel retorna nenhum usuário!")
    @GetMapping("/all")
    public List<UsuarioLowDTO> getAll(){
        return service.getAll();
    }

    @Operation(summary = "Atualiza os dados cadastrado do usuário",
            tags = "User")
    @ApiResponse(responseCode = "200", description = "Dados do usuário atualizados com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não foi possivel atualizar os dados do usuário!")
    @PutMapping
    public UsuarioDTO update(@RequestBody UsuarioDTO user){
        return service.update(user);
    }

    @Operation(summary = "Exclui um usuário com base no ID informado",
            tags = "User")
    @ApiResponse(responseCode = "200", description ="Usuário deletado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não foi possivel deletar o usuário informado!")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        service.deleteUserById(id);
    }

    @Operation(summary = "Retorna os dados de um usuário baseado no ID",
            tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Retorno dos dados do usuário"),
            @ApiResponse(responseCode = "404",
            description = "O usuário com o id " +
                    "informado não foi encontrado",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorDTO.class)
            ))
    })
    @GetMapping("/{id}")
    public UsuarioLowDTO findById(@PathVariable(name = "id") Long id){
       return service.findUserById(id);
    }

}
