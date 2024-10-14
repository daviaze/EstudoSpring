package estudo.spring.domain.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record MedicoPostDTO(
  @NotBlank
  String nome,
  @NotBlank
 LocalDate dataNascimento,
 @NotBlank
  String crm ) {
    
}
