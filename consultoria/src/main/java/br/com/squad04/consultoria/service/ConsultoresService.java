package br.com.squad04.consultoria.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Consultores;
import br.com.squad04.consultoria.repository.ConsultoresRepository;

@Service
public class ConsultoresService {
    @Autowired
    private ConsultoresRepository consultoresRepository;

    public List<Consultores> getAllConsultores(){
        return consultoresRepository.findAll();
    }

    public Optional<Consultores> getConsultorById(long idConsultor){
        return consultoresRepository.findById(idConsultor);
    }

    public Consultores saveConsultor(Consultores consultor){
        if (consultor.getIdConsultor() == null) {
            // Novo consultor, definir data de cadastro
            consultor.setDataCadastro(new Timestamp(System.currentTimeMillis()));
        }else{
            // Atualização, manter a data de cadastro original
            Consultores consultorExistente = consultoresRepository.findById(consultor.getIdConsultor()).orElseThrow();
            consultor.setDataCadastro(consultorExistente.getDataCadastro());
        }
        return consultoresRepository.save(consultor);
    }

    public void deleteConsultor(long idConsultor){
        consultoresRepository.deleteById(idConsultor);
    }
}
