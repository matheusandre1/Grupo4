package br.com.squad04.consultoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Consultas;
import br.com.squad04.consultoria.repository.ConsultasRepository;

@Service
public class ConsultasService {
    @Autowired
    private ConsultasRepository consultasRepository;

    public List<Consultas> getAllConsultas(){
        return consultasRepository.findAll();
    }

    public Optional<Consultas> getConsultaById(long idConsulta){
        return consultasRepository.findById(idConsulta);
    }

    public Consultas saveConsulta(Consultas consulta){
        return consultasRepository.save(consulta);
    }

    public void deleteConsulta(long idConsulta){
        consultasRepository.deleteById(idConsulta);
    }
}
