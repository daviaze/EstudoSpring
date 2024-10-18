package estudo.spring.infra.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import estudo.spring.domain.entities.Especialidade;
import estudo.spring.domain.entities.Medico;
import estudo.spring.domain.entities.Medico.StatusMedico;

import java.time.LocalDateTime;

public interface IMedicoRepository extends JpaRepository<Medico, Long>{

    @Query("""
        select m from Medico m
        where m.status = 1
        and m.especialidade = :especialidade
        and m.id not in(select c.medico.id from Consulta c
        where c.data = :data)
        order by rand()
        limit 1
    """)
    Medico chooseRandomAvailableMedico(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.status from Medico m where m.id = :idMedico
            """)
    StatusMedico findStatusById(Long idMedico);
}
