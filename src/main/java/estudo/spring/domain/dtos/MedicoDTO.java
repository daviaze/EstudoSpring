package estudo.spring.domain.dtos;

import estudo.spring.domain.entities.Medico;

public record MedicoDTO(Long id, String nome, String crm) {
    public MedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm());
    }
}
