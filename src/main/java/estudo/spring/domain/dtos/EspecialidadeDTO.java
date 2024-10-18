package estudo.spring.domain.dtos;

import estudo.spring.domain.entities.Especialidade;

public record EspecialidadeDTO(Long id, String nome) {
    public EspecialidadeDTO(Especialidade especialidade){
        this(especialidade.getId(), especialidade.getDescricao());
    }
}
