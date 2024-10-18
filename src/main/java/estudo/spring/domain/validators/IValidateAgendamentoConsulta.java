package estudo.spring.domain.validators;

import estudo.spring.domain.dtos.ConsultaPostDTO;

public interface IValidateAgendamentoConsulta {
    public void validar(ConsultaPostDTO consultaDTO);
}
