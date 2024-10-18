package estudo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import estudo.spring.domain.dtos.EspecialidadeDTO;
import estudo.spring.domain.dtos.EspecialidadePostDTO;
import estudo.spring.domain.entities.Especialidade;
import estudo.spring.infra.Repositories.IEspecialidadeRepository;
import estudo.spring.services.interfaces.IEspecialidadeService;

@Service
public class EspecialidadeService implements IEspecialidadeService {

    @Autowired
    private IEspecialidadeRepository _especialidadeRepository;

    @Override
    public Page<Especialidade> get(Pageable paginacao) {
        try{
            Page<Especialidade> especialidades = this._especialidadeRepository.findAll(paginacao);
            return especialidades;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public EspecialidadeDTO getById(Long id) {
        try{
            Especialidade especialidade = this._especialidadeRepository.getReferenceById(id);

            return new EspecialidadeDTO(especialidade);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public EspecialidadeDTO post(EspecialidadePostDTO especialidadeDTO) {
        try{

            Especialidade especialidade = new Especialidade(especialidadeDTO);
            this._especialidadeRepository.save(especialidade);

            return new EspecialidadeDTO(especialidade);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try{
            this._especialidadeRepository.deleteById(id);
        }catch(Exception e){
            throw e;
        }
    }
    
}
