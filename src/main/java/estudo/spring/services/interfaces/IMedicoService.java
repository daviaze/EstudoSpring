package estudo.spring.services.interfaces;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import estudo.spring.domain.dtos.MedicoDTO;
import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.dtos.MedicoPutDTO;
import estudo.spring.domain.entities.Medico;
import estudo.spring.services.results.Response;
import estudo.spring.services.results.Result;

public interface IMedicoService {
    public Response  get(Pageable paginacao); 
    public MedicoDTO getById(Long id); 
    public MedicoDTO post(MedicoPostDTO medico);
    public MedicoDTO put(Long id, MedicoPutDTO medico);
    public void delete(Long id);
}
