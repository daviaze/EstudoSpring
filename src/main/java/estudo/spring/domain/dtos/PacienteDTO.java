package estudo.spring.domain.dtos;
import java.time.LocalDate;
import estudo.spring.domain.entities.Paciente;

public record PacienteDTO(Long id, String nome, String genero, LocalDate dataNascimento) {
        public PacienteDTO(Paciente medico){
        this(medico.getId(), medico.getNome(), medico.getGenero(), medico.getDataNascimento());
    }
}
