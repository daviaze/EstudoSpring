package estudo.spring.domain.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacientePostDTO(
    @NotBlank
    String nome,
    String genero,
    @NotNull
    LocalDate dataNascimento) {
    
}
