package estudo.spring.domain.validators;
import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.infra.Exceptions.ValidationException;

@Component
public class ValidateDataConsulta implements IValidateAgendamentoConsulta {
    public void validar(ConsultaPostDTO consultaDTO){
        var dataConsulta = consultaDTO.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidationException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
