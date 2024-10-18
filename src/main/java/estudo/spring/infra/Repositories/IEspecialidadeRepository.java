package estudo.spring.infra.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.spring.domain.entities.Especialidade;

public interface IEspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    
}
