package br.edu.unichristus.backend.controller;

import br.edu.unichristus.backend.domain.dto.ErrorDTO;
import br.edu.unichristus.backend.domain.dto.LivroDTO;
import br.edu.unichristus.backend.domain.dto.LivroLowDTO;
import br.edu.unichristus.backend.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @Operation(summary = "Cadastra dados referentes a um livro",
            tags = "Livro")
    @ApiResponse(responseCode = "200", description = "Livro cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Possíveis causas:" +
            "\n- O título, autor ou categoria estão vazios" +
            "\n- O ano de publicação é inválido")
    @PostMapping
    public LivroDTO create(@RequestBody LivroDTO livro) {
        return service.create(livro);
    }

    @Operation(summary = "Retorna a lista de todos os livros cadastrados",
            tags = "Livro")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso!")
    @GetMapping("/all")
    public List<LivroLowDTO> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Atualiza os dados de um livro existente",
            tags = "Livro")
    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @PutMapping
    public LivroDTO update(@RequestBody LivroDTO livro) {
        return service.update(livro);
    }

    @Operation(summary = "Exclui um livro com base no ID informado",
            tags = "Livro")
    @ApiResponse(responseCode = "200", description = "Livro excluído com sucesso!")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        service.deleteLivroById(id);
    }

    @Operation(summary = "Retorna os dados de um livro baseado no ID",
            tags = "Livro")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorno dos dados do livro"),
            @ApiResponse(responseCode = "404",
                    description = "O livro com o ID informado não foi encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)
                    ))
    })
    @GetMapping("/{id}")
    public LivroLowDTO findById(@PathVariable(name = "id") Long id) {
        return service.findLivroById(id);
    }
}
