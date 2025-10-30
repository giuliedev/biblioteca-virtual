package br.edu.unichristus.backend.service;

import br.edu.unichristus.backend.domain.dto.EmprestimoDTO;
import br.edu.unichristus.backend.domain.dto.EmprestimoLowDTO;
import br.edu.unichristus.backend.domain.model.Emprestimo;
import br.edu.unichristus.backend.exception.ApiException;
import br.edu.unichristus.backend.repository.EmprestimoRepository;
import br.edu.unichristus.backend.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository repository;

    public EmprestimoDTO create(EmprestimoDTO dto) {
        var emprestimo = MapperUtil.parseListObjects(dto, Emprestimo.class);
        var emprestimoPersist = repository.save(emprestimo);
        return MapperUtil.parseObject(emprestimoPersist, EmprestimoDTO.class);
    }
    public List<EmprestimoLowDTO> getAll(){
        return MapperUtil.parseListObjects(repository.findAll(), EmprestimoLowDTO.class);
    }
    public EmprestimoDTO update(EmprestimoDTO dto){
        var emprestimo = MapperUtil.parseObject(dto,Emprestimo.class);
        var emprestimoPersist = repository.save(emprestimo);
        return MapperUtil.parseObject(emprestimoPersist, EmprestimoDTO.class);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public EmprestimoLowDTO findById(Long id) {
        var emprestimo = repository.findById(id).orElseThrow(
                () -> new ApiException(HttpStatus.NOT_FOUND,
                        "unichristus.service.emprestimo.notfound",
                        "O empréstimo com o ID informado não foi encontrado.")
        );
        return MapperUtil.parseObject(emprestimo, EmprestimoLowDTO.class);
    }
}