package estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.services.interfaces.IConsultaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private IConsultaService _consultaService;
    @PostMapping
    public ResponseEntity post(@RequestBody @Valid ConsultaPostDTO consultaDTO, UriComponentsBuilder uriBuilder){
        var consulta = _consultaService.post(consultaDTO);

        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consulta.id()).toUri();

        return ResponseEntity.created(uri).body(consulta);
    }
}
