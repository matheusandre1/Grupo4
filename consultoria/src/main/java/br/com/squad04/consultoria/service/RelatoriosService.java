package br.com.squad04.consultoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Relatorios;
import br.com.squad04.consultoria.repository.RelatoriosRespository;

@Service
public class RelatoriosService {
    
    @Autowired
    private RelatoriosRespository relatoriosRespository;

    public List<Relatorios> getAllRelatorios(){
        return relatoriosRespository.findAll();
    }

    public Optional<Relatorios> getRelatorioById(Long idRelatorio){
        return relatoriosRespository.findById(idRelatorio);
    }

    public Relatorios saveRelatorio(Relatorios relatorio){
        return relatoriosRespository.save(relatorio);
    }

    public void deleteRelatorio(Long idRelatorio){
        relatoriosRespository.deleteById(idRelatorio);
    }
}
