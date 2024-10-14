package estudo.spring.domain.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
}
