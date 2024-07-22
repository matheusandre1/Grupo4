package br.com.squad04.consultoria.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.squad04.consultoria.model.FeedBack;
import br.com.squad04.consultoria.repository.FeedBackRepository;

public class FeedBackService {

    @Autowired
    private FeedBackRepository feedbackRepository;

    public List<FeedBack> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public FeedBack saveFeedback(FeedBack feedback) {
        feedback.setDataEnvio(new Timestamp(System.currentTimeMillis()));
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}


