package estudo.spring.domain.dtos;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ConsultaPostDTO(
Long idMedico,
@NotNull
Long idPaciente,
Long idEspecialidade,
@NotNull
@Future
LocalDateTime data) {
    
}
