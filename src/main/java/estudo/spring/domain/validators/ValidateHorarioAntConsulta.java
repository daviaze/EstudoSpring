package estudo.spring.domain.validators;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import java.time.Duration;

import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.infra.Exceptions.ValidationException;

@Component
public class ValidateHorarioAntConsulta implements IValidateAgendamentoConsulta {
    public void validar(ConsultaPostDTO consultaDTO){
        var dataConsulta = consultaDTO.data();
        var agora = LocalDateTime.now();
        var dif = Duration.between(agora, dataConsulta).toMinutes();

        if(dif < 30){
            throw new ValidationException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
