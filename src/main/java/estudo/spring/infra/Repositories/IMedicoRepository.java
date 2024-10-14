package estudo.spring.infra.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.spring.domain.entities.Medico;

public interface IMedicoRepository extends JpaRepository<Medico, Long>{
    
}
