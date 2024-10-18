package estudo.spring.domain.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.domain.entities.Medico.StatusMedico;
import estudo.spring.infra.Exceptions.ValidationException;
import estudo.spring.infra.Repositories.IMedicoRepository;

@Component
public class ValidateMedicoAtivo implements IValidateAgendamentoConsulta {
    @Autowired
    private IMedicoRepository _medicoRepository;

    public void validar (ConsultaPostDTO consultaDTO){
        if(consultaDTO.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = _medicoRepository.findStatusById(consultaDTO.idMedico());

        if(medicoEstaAtivo == StatusMedico.INATIVO){
            throw new ValidationException("Consulta não pode ser agendada com médico inativo.");
        }
    }
}
