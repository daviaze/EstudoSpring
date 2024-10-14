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
import estudo.spring.domain.entities.Medico;
import estudo.spring.infra.Repositories.IMedicoRepository;
import estudo.spring.services.interfaces.IMedicoService;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoRepository _medicoRepository;

    @Override
    public Page<Medico> get(Pageable paginacao) {
        try{
            Page<Medico> medicos = this._medicoRepository.findAll(paginacao);
            return medicos;
        }catch(Exception e){
            throw e;
        }
    }


    @Transactional
    @Override
    public void post(MedicoPostDTO medico) {
        try{
            Medico med = new Medico(medico);
            System.out.println(med.toString());
            this._medicoRepository.save(med);
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
