package estudo.spring.domain.dtos;
import java.time.LocalDateTime;
import estudo.spring.domain.entities.Consulta;

public record ConsultaDTO(Long id, MedicoDTO medico, PacienteDTO paciente, LocalDateTime data) {
        public ConsultaDTO(Consulta consulta){
        this(consulta.getId(), new MedicoDTO(consulta.getMedico()),
         new PacienteDTO(consulta.getPaciente()), consulta.getData());
    }
}
