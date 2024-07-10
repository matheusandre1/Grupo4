package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.FeedBack;
import br.com.squad04.consultoria.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedBackImp implements FeedBackService{
    @Autowired
    private FeedBackRepository feedBackRepository;


    @Override
    public void criar(FeedBack feedBack) {
        feedBackRepository.save(feedBack);
    }

    @Override
    public void alterar(Long id, String mensagem) {
        var feedback =feedBackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback não encontrado com o id " + id));
        feedBackRepository.save(feedback);
    }


}
