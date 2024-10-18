package estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import estudo.spring.domain.dtos.EspecialidadeDTO;
import estudo.spring.domain.dtos.EspecialidadePostDTO;
import estudo.spring.domain.entities.Especialidade;
import estudo.spring.services.interfaces.IEspecialidadeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("especialidades")
public class EspecialidadeController {
    @Autowired
    private IEspecialidadeService _especialidadeService;

    @GetMapping
    public ResponseEntity<Page<Especialidade>> getAll(Pageable paginacao){
        var page = _especialidadeService.get(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> getById(@PathVariable @NotNull Long id){
        var especialidade = _especialidadeService.getById(id);
        return ResponseEntity.ok(especialidade);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid EspecialidadePostDTO especialidadeDTO,
     UriComponentsBuilder uriBuilder){
        var especialidade = _especialidadeService.post(especialidadeDTO);

        var uri = uriBuilder.path("/especialidade/{id}").buildAndExpand(especialidade.id()).toUri();

        return ResponseEntity.created(uri).body(especialidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @NotNull Long id){
        _especialidadeService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
