package estudo.spring.infra.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.spring.domain.entities.Medico;
import estudo.spring.domain.entities.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Long>{
    
}
