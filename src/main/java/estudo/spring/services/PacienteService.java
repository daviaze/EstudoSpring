package estudo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import estudo.spring.domain.dtos.PacienteDTO;
import estudo.spring.domain.dtos.PacientePostDTO;
import estudo.spring.domain.dtos.PacientePutDTO;
import estudo.spring.domain.entities.Paciente;
import estudo.spring.infra.Repositories.IPacienteRepository;
import estudo.spring.services.interfaces.IPacienteService;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository _pacienteRepository;

    @Override
    public Page<Paciente> get(Pageable paginacao) {
        try{
            Page<Paciente> pacientes = this._pacienteRepository.findAll(paginacao);
            return pacientes;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public PacienteDTO getById(Long id) {
        try{
            Paciente paciente = this._pacienteRepository.getReferenceById(id);

            return new PacienteDTO(paciente); 
        }catch(Exception e){
            throw e;
        }
    }

    @Transactional
    @Override
    public PacienteDTO post(PacientePostDTO paciente) {
        Paciente med = new Paciente(paciente);

        this._pacienteRepository.save(med);

        return new PacienteDTO(med);
    }

    @Transactional
    @Override
    public PacienteDTO put(Long id, PacientePutDTO paciente) {
        try{
            Paciente ref = _pacienteRepository.getReferenceById(id);
            ref.AtualizaCampos(paciente);

            return new PacienteDTO(ref);
        }catch(Exception e){
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        try{
            _pacienteRepository.deleteById(id);
        }catch(Exception e){
            throw e;
        }
    }
    
}
