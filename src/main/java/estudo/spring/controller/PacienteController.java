package estudo.spring.controller;

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
import org.springframework.web.util.UriComponentsBuilder;
import estudo.spring.domain.dtos.PacienteDTO;
import estudo.spring.domain.dtos.PacientePostDTO;
import estudo.spring.domain.dtos.PacientePutDTO;
import estudo.spring.domain.entities.Paciente;
import estudo.spring.services.interfaces.IPacienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService _pacienteService;

    @GetMapping
    public ResponseEntity<Page<Paciente>> getAll(Pageable paginacao){
        var page = _pacienteService.get(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable @NotNull Long id){
        var medico = _pacienteService.getById(id);
        return ResponseEntity.ok(medico);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid PacientePostDTO pacienteDTO, UriComponentsBuilder uriBuilder){
        var medico = _pacienteService.post(pacienteDTO);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.id()).toUri();

        return ResponseEntity.created(uri).body(medico);
    }

    @PatchMapping("/{id}")
    public ResponseEntity put(@RequestBody @Valid PacientePutDTO pacienteDTO, @PathVariable @NotNull Long id){
        _pacienteService.put(id, pacienteDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @NotNull Long id){
        _pacienteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
