package estudo.spring.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import estudo.spring.domain.dtos.PacientePostDTO;
import estudo.spring.domain.dtos.PacientePutDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column(name = "data_criado")
    private LocalDateTime dataCriado;

    private String genero;

    public Paciente(PacientePostDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.dataNascimento = pacienteDTO.dataNascimento();
        this.genero = pacienteDTO.genero();
        this.dataCriado = LocalDateTime.now();
    }

    public void AtualizaCampos(PacientePutDTO pacienteDTO){
        this.nome = pacienteDTO.nome();
    }
}
