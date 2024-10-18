package estudo.spring.domain.dtos;

import estudo.spring.domain.entities.Especialidade;
import estudo.spring.domain.entities.Medico;

public record MedicoDTO(Long id, String nome, String crm, EspecialidadeDTO especialidade) {
    public MedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(),
         new EspecialidadeDTO(medico.getEspecialidade()));
    }
}
