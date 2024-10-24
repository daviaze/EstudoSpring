package estudo.spring.domain.dtos;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoPostDTO(
  @NotBlank
  String nome,
  @NotNull
  LocalDate dataNascimento,
  @NotNull
  Long idEspecialidade,
  @NotBlank
  String crm ) {
    
}
