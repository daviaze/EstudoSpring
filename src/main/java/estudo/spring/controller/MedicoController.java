package estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Medico> getAll(Pageable paginacao){
        return _medicoService.get(paginacao);
    }

    @PostMapping
    public void post(@RequestBody @Valid MedicoPostDTO medicoDTO){
        _medicoService.post(medicoDTO);
    }

    @PatchMapping("/{id}")
    public void put(@RequestBody @Valid MedicoPutDTO medicoDTO, @PathVariable @NotNull Long id){
        _medicoService.put(id, medicoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull Long id){
        _medicoService.delete(id);
    }
}
