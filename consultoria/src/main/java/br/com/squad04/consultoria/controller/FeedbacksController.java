package br.com.squad04.consultoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.model.Feedbacks;
import br.com.squad04.consultoria.service.ClientesService;
import br.com.squad04.consultoria.service.FeedbacksService;

@Controller
@RequestMapping("/feedbacks")
public class FeedbacksController {

    @Autowired
    private FeedbacksService feedbackService;

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public String getAllFeedbacks(Model model) {
        List<Feedbacks> feedbacks =  feedbackService.getAllFeedbacks();
        model.addAttribute("feedbacks", feedbacks);
        return "home";
    }

    @GetMapping("/novo")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedbacks", new Feedbacks());
        
        List<Clientes> cliente = clientesService.getAllClientes();
        model.addAttribute("cliente", cliente); 

        return "feedback/form";
    }

    @PostMapping
    public String saveFeedback(@ModelAttribute Feedbacks feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/home";
    }

    @GetMapping("/deletar/{idFeedback}")
    public String deleteFeedback(@PathVariable("idFeedback") Long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/home";
    }
}
