package estudo.spring.domain.entities;
import java.time.LocalDate;
import java.time.LocalDateTime;

import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.dtos.MedicoPutDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm; 
    private String nome;
    private StatusMedico status;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_criado")
    private LocalDateTime dataCriado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    public Medico(MedicoPostDTO medicoDTO, Especialidade especialidade){
        this.nome = medicoDTO.nome();
        this.crm = medicoDTO.crm();
        this.dataNascimento = medicoDTO.dataNascimento();
        this.dataCriado = LocalDateTime.now();
        this.especialidade = especialidade;
        this.status = StatusMedico.ATIVO;
    }

    public void AtualizaCampos(MedicoPutDTO medicoDTO){
        this.nome = medicoDTO.nome();
    }

    public enum StatusMedico{
        INATIVO(0),
        ATIVO(1);

        private int codigo;

        StatusMedico(int codigo) {
            this.codigo = codigo;
        }
    
        public int getCodigo() {
            return codigo;
        }
    }
}
