package estudo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import estudo.spring.domain.dtos.ConsultaDTO;
import estudo.spring.domain.dtos.ConsultaPostDTO;
import estudo.spring.domain.entities.Consulta;
import estudo.spring.domain.entities.Especialidade;
import estudo.spring.domain.entities.Medico;
import estudo.spring.domain.entities.Paciente;
import estudo.spring.domain.validators.IValidateAgendamentoConsulta;
import estudo.spring.infra.Repositories.IConsultaRepository;
import estudo.spring.infra.Repositories.IEspecialidadeRepository;
import estudo.spring.infra.Repositories.IMedicoRepository;
import estudo.spring.infra.Repositories.IPacienteRepository;
import estudo.spring.services.interfaces.IConsultaService;
import jakarta.validation.ValidationException;

@Service
public class ConsultaService implements IConsultaService{

    @Autowired
    private IConsultaRepository _consultaRepository;

    @Autowired
    private IMedicoRepository _medicoRepository;

    @Autowired
    private IPacienteRepository _pacienteRepository;

    @Autowired
    private IEspecialidadeRepository _especialidadeRepository;

    @Autowired
    private List<IValidateAgendamentoConsulta> validators;

    @Override
    public ConsultaDTO post(ConsultaPostDTO consultaDTO) {
        try{
            if(!_pacienteRepository.existsById(consultaDTO.idPaciente())){
                throw new ValidationException("Id do paciente informado não existe!");
            }

            if(consultaDTO.idMedico() != null && !_medicoRepository.existsById(consultaDTO.idMedico())){
                throw new ValidationException("Id do médico informado não existe!");
            }

            this.validators.forEach(v -> v.validar(consultaDTO));

            Paciente paciente = _pacienteRepository.getReferenceById(consultaDTO.idPaciente());
            Medico medico = chooseMedico(consultaDTO);

            var consulta = new Consulta(consultaDTO, medico, paciente);
            _consultaRepository.save(consulta);

            return new ConsultaDTO(consulta);
        }catch(Exception e){
            throw e;
        }
    }

    Medico chooseMedico(ConsultaPostDTO consultaDTO){
        if(consultaDTO.idMedico() != null){
            return _medicoRepository.getReferenceById(consultaDTO.idMedico());
        }

        if(consultaDTO.idEspecialidade() == null){
            throw new ValidationException("Especialidade é obrigatória quando o médico não é escolhido.");
        }

        Especialidade especialidade = this._especialidadeRepository
        .getReferenceById(consultaDTO.idEspecialidade());
        
        return _medicoRepository.chooseRandomAvailableMedico(especialidade, consultaDTO.data());
    }
}
