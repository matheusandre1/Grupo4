package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.FeedBack;
import br.com.squad04.consultoria.model.Relatorio;

public interface RelatorioService {

    Relatorio criar(Relatorio relatorio);

    Relatorio editar(Relatorio relatorio);

    Relatorio visualizar(Long id);

}

