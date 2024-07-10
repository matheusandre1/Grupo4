package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.FeedBack;

public interface FeedBackService {

    void criar (FeedBack feedBack);
    void alterar(Long id,String mensagem);

}
