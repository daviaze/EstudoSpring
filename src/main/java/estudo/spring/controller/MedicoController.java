package estudo.spring.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.dtos.MedicoPutDTO;
import estudo.spring.domain.entities.Medico;
import estudo.spring.services.interfaces.IMedicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    
    @Autowired
    private IMedicoService _medicoService;

    @GetMapping
    public ResponseEntity<Page<Medico>> getAll(Pageable paginacao){
        var page = _medicoService.get(paginacao);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid MedicoPostDTO medicoDTO){
        _medicoService.post(medicoDTO);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity put(@RequestBody @Valid MedicoPutDTO medicoDTO, @PathVariable @NotNull Long id){
        _medicoService.put(id, medicoDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @NotNull Long id){
        _medicoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
