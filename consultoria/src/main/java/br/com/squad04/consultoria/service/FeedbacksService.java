package br.com.squad04.consultoria.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Feedbacks;
import br.com.squad04.consultoria.repository.FeedbacksRepository;

@Service
public class FeedbacksService {

    @Autowired
    private FeedbacksRepository feedbackRepository;

    public List<Feedbacks> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedbacks saveFeedback(Feedbacks feedback) {
        feedback.setDataFeedback(new Timestamp(System.currentTimeMillis()));
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}


