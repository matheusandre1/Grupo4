package br.com.squad04.consultoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.squad04.consultoria.model.FeedBack;
import br.com.squad04.consultoria.service.FeedBackService;

@Controller
@RequestMapping("/feedbacks")
public class FeedBackController {

    @Autowired
    private FeedBackService feedbackService;

    @GetMapping
    public String getAllFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        return "feedback/list";
    }

    @GetMapping("/novo")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new FeedBack());
        return "feedback/form";
    }

    @PostMapping
    public String saveFeedback(@ModelAttribute FeedBack feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/deletar/{id}")
    public String deleteFeedback(@PathVariable("id") Long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/feedbacks";
    }
}
