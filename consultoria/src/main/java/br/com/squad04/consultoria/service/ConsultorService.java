package br.com.squad04.consultoria.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Consultor;
import br.com.squad04.consultoria.repository.ConsultorRepository;

@Service
public class ConsultorService {
    @Autowired
    private ConsultorRepository consultorRepository;

    public List<Consultor> getAllConsultores(){
        return consultorRepository.findAll();
    }

    public Optional<Consultor> getConsultorById(long idConsultor){
        return consultorRepository.findById(idConsultor);
    }

    public Consultor saveConsultor(Consultor consultor){
        if (consultor.getIdConsultor() == null) {
            // Novo consultor, definir data de cadastro
            consultor.setDataCadastro(new Timestamp(System.currentTimeMillis()));
        } else {
            // Atualização, manter a data de cadastro original
            Consultor existingConsultor = consultorRepository.findById(consultor.getIdConsultor()).orElseThrow();
            consultor.setDataCadastro(existingConsultor.getDataCadastro());
        }
        return consultorRepository.save(consultor);
    }

    public void deleteConsultor(long idConsultor){
        consultorRepository.deleteById(idConsultor);
    }
}
