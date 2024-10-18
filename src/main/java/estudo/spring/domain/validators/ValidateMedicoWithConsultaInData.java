package estudo.spring.domain.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.infra.Exceptions.ValidationException;
import estudo.spring.infra.Repositories.IConsultaRepository;

@Component
public class ValidateMedicoWithConsultaInData implements IValidateAgendamentoConsulta {
    @Autowired
    private IConsultaRepository _consultaRepository;

    public void validar(ConsultaPostDTO consultaDTO){
        var medicoPossuiOutraConsultaNoMmesmoHorario = _consultaRepository
        .existsByMedicoIdAndData(consultaDTO.idMedico(), consultaDTO.data());

        if(medicoPossuiOutraConsultaNoMmesmoHorario){
            throw new ValidationException("Médico já possui outra consulta agendada nesse mesmo horário.");
        }
    }
}
