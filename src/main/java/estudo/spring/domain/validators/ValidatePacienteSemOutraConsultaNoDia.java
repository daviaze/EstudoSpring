package estudo.spring.domain.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.infra.Exceptions.ValidationException;
import estudo.spring.infra.Repositories.IConsultaRepository;

@Component
public class ValidatePacienteSemOutraConsultaNoDia implements IValidateAgendamentoConsulta {
    @Autowired
    private IConsultaRepository _consultaRepository;

    public void validar(ConsultaPostDTO consultaDTO){
        var primeiroHorario = consultaDTO.data().withHour(7);
        var ultimoHorario = consultaDTO.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = _consultaRepository
        .existsByPacienteIdAndDataBetween(consultaDTO.idPaciente(),  primeiroHorario, ultimoHorario);

        if(pacientePossuiOutraConsultaNoDia){
            throw new ValidationException("Paciente já possui uma consulta agendada nesse dia.");
        }
    }
}
