package estudo.spring.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record MedicoPutDTO(
@NotBlank
String nome) {
}
