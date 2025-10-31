package br.edu.unichristus.backend.controller;

import br.edu.unichristus.backend.domain.dto.CategoriaDTO;
import br.edu.unichristus.backend.domain.dto.CategoriaLowDTO;
import br.edu.unichristus.backend.domain.dto.ErrorDTO;
import br.edu.unichristus.backend.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Operation(summary = "Cadastra uma nova categoria", tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Categoria cadastrada com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas: dados obrigatórios não preenchidos.")
    @PostMapping
    public CategoriaDTO create(@RequestBody CategoriaDTO dto) {
        return service.create(dto);
    }

    @Operation(summary = "Retorna todas as categorias cadastradas", tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso!")
    @GetMapping("/all")
    public List<CategoriaLowDTO> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Atualiza os dados de uma categoria", tags = "Categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso!")
    @PutMapping
    public CategoriaDTO update(@RequestBody CategoriaDTO dto) {
        return service.update(dto);
    }

    @Operation(summary = "Exclui uma categoria pelo ID", tags = "Categoria")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria excluída com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Categoria com o ID informado não encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }

    @Operation(summary = "Retorna os dados de uma categoria pelo ID", tags = "Categoria")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dados da categoria retornados com sucesso!"),
            @ApiResponse(responseCode = "404",
                    description = "A categoria com o ID informado não foi encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })
    @GetMapping("/{id}")
    public CategoriaLowDTO findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }
}

