package br.edu.unichristus.backend.controller;
import br.edu.unichristus.backend.domain.dto.EmprestimoDTO;
import br.edu.unichristus.backend.domain.dto.EmprestimoLowDTO;
import br.edu.unichristus.backend.domain.dto.ErrorDTO;
import br.edu.unichristus.backend.service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService service;

    @Operation(summary = "Cadastra um novo empréstimo", tags = "Emprestimo")
    @ApiResponse(responseCode = "200", description = "Empréstimo cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas: dados obrigatórios não preenchidos.")
    @PostMapping
    public EmprestimoDTO create(@RequestBody EmprestimoDTO dto){
        return service.create(dto);
    }

    @Operation(summary = "Retorna todos os empréstimos cadastrados", tags = "Emprestimo")
    @ApiResponse(responseCode = "200", description = "Listagem de empréstimos retornada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não foi possivel retorna a listagem de empréstimos.")
    @GetMapping("/all")
    public List<EmprestimoLowDTO> getAll(){
        return service.getAll();
    }

    @Operation(summary = "Atualiza os dados de empréstimo cadastrado", tags = "Emprestimo")
    @ApiResponse(responseCode = "200", description = "Empréstimo atualizado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não foi possivel atualizar o empréstimo cadastrado.")
    @PutMapping
    public EmprestimoDTO update(@RequestBody EmprestimoDTO dto){
        return service.update(dto);
    }

    @Operation(summary = "Exclui um emprestimo com base no ID informado", tags = "Emprestimo")
    @ApiResponse(responseCode = "200", description = "Empréstimo deletado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não foi possivel excluir o empréstimo cadastrado.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")Long id){
        service.deleteById(id);
    }

    @Operation(summary = "Retorna os dados de um empréstimo baseado no ID", tags = "Emprestimo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorno dos dados do empréstimo"),
            @ApiResponse(responseCode = "404",
                    description = "O empréstimo com o ID informado não foi encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })
    @GetMapping("/{id}")
    public EmprestimoLowDTO findById(@PathVariable (name = "id")Long id){
        return service.findById(id);
    }
}

