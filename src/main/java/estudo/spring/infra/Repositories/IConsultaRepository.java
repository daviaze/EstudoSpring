package estudo.spring.infra.Repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.spring.domain.entities.Consulta;

public interface IConsultaRepository extends JpaRepository<Consulta, Long>{

    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdAndDataBetween(Long idPaciente,
     LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
