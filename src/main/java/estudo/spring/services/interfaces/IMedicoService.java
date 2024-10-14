package estudo.spring.services.interfaces;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.dtos.MedicoPutDTO;
import estudo.spring.domain.entities.Medico;

public interface IMedicoService {
    public Page<Medico> get(Pageable paginacao); 
    public void post(MedicoPostDTO medico);
    public void put(Long id, MedicoPutDTO medico);
    public void delete(Long id);
}
