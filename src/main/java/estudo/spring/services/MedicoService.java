package estudo.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import estudo.spring.domain.dtos.MedicoDTO;
import estudo.spring.domain.dtos.MedicoPostDTO;
import estudo.spring.domain.dtos.MedicoPutDTO;
import estudo.spring.domain.entities.Especialidade;
import estudo.spring.domain.entities.Medico;
import estudo.spring.infra.Repositories.IEspecialidadeRepository;
import estudo.spring.infra.Repositories.IMedicoRepository;
import estudo.spring.services.interfaces.IMedicoService;
import estudo.spring.services.results.Response;
import estudo.spring.services.results.Result;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoRepository _medicoRepository;

    @Autowired
    private IEspecialidadeRepository _EspecialidadeRepository;

    @Override
    public Response get(Pageable paginacao) {
        try{
            Page<Medico> medicos = this._medicoRepository.findAll(paginacao);
            return Result.onSuccess(medicos);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public MedicoDTO getById(Long id) {
        try{
            Medico medico = this._medicoRepository.getReferenceById(id);

            return new MedicoDTO(medico);
        }catch(Exception e){
            throw e;
        }
    }

    @Transactional
    @Override
    public MedicoDTO post(MedicoPostDTO medico) {
        try{
            System.err.println(medico);
            Especialidade especialidade =
             _EspecialidadeRepository.getReferenceById(medico.idEspecialidade());
            Medico med = new Medico(medico, especialidade);
            this._medicoRepository.save(med);

            return new MedicoDTO(med);
        }catch(Exception e){
            throw e;
        }
    }


    @Transactional
    @Override
    public MedicoDTO put(Long id, MedicoPutDTO medico) {
        try{
            Medico ref = _medicoRepository.getReferenceById(id);
            ref.AtualizaCampos(medico);

            return new MedicoDTO(ref);
        }catch(Exception e){
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        try{
            _medicoRepository.deleteById(id);
        }catch(Exception e){
            throw e;
        }
    }
}
