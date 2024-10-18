package estudo.spring.services.interfaces;

import estudo.spring.domain.dtos.ConsultaDTO;
import estudo.spring.domain.dtos.ConsultaPostDTO;

public interface IConsultaService {
    public ConsultaDTO post(ConsultaPostDTO medico);
}
