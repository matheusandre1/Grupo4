package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.Relatorio;
import br.com.squad04.consultoria.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RelatorioImp implements RelatorioService{

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Override
    public Relatorio criar(Relatorio relatorio) {
        return  relatorioRepository.save(relatorio);
    }

    @Override
    public Relatorio editar(Relatorio relatorio) {
        if (relatorio.getId() == null || !relatorioRepository.existsById(relatorio.getId())) {
            throw new RuntimeException("Relatório não encontrado");
        }
        return relatorioRepository.save(relatorio);
    }

    @Override
    public Relatorio visualizar(Long id) {
        try {
            return relatorioRepository.findById(id).orElseThrow(() -> new RuntimeException("Relatorio não encontrado"));
        }catch (NoSuchElementException e) {
            throw new RuntimeException("Relatório não encontrado", e);
        }
}
}
