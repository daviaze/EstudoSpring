package estudo.spring.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import estudo.spring.domain.dtos.EspecialidadeDTO;
import estudo.spring.domain.dtos.EspecialidadePostDTO;
import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.entities.Especialidade;

public interface IEspecialidadeService {
    public Page<Especialidade> get(Pageable paginacao); 
    public EspecialidadeDTO getById(Long id); 
    public EspecialidadeDTO post(EspecialidadePostDTO especialidadeDTO);
    public void delete(Long id);
}
