package estudo.spring.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import estudo.spring.domain.dtos.PacienteDTO;
import estudo.spring.domain.dtos.PacientePostDTO;
import estudo.spring.domain.dtos.PacientePutDTO;
import estudo.spring.domain.entities.Paciente;

public interface IPacienteService {
    public Page<Paciente> get(Pageable paginacao); 
    public PacienteDTO getById(Long id); 
    public PacienteDTO post(PacientePostDTO paciente);
    public PacienteDTO put(Long id, PacientePutDTO paciente);
    public void delete(Long id);
}
