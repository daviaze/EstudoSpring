package estudo.spring.domain.entities;

import java.time.LocalDate;

import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.dtos.MedicoPutDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Medico(MedicoPostDTO medicoDTO){
        this.nome = medicoDTO.nome();
        this.crm = medicoDTO.crm();
    }

    public void AtualizaCampos(MedicoPutDTO medicoDTO){
        this.nome = medicoDTO.nome();
    }


    @Override
    public String toString() {
        return "NOME: "+this.getNome()+" CRM: "+this.crm;
    }
}
