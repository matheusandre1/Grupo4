package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.Consultas;
import br.com.squad04.consultoria.repository.ConsultasRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultasServiceImp implements ConsultasService {

    private final ConsultasRepositories consultaRepository;

    @Autowired
    public ConsultasServiceImp(ConsultasRepositories consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consultas saveConsulta(Consultas consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consultas> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Optional<Consultas> getConsultaById(Long id) {
        return consultaRepository.findById(id);
    }

    @Override
    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
