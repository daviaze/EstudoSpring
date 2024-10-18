package estudo.spring.domain.entities;

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
import java.time.LocalDateTime;

import estudo.spring.domain.dtos.EspecialidadePostDTO;

@Table(name = "Especialidades")
@Entity(name = "Especialidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @Column(name = "data_criado")
    private LocalDateTime dataCriado;

    public Especialidade(EspecialidadePostDTO especialidadeDTO) {
       this.descricao = especialidadeDTO.descricao();
       this.dataCriado = LocalDateTime.now();
    }
}
