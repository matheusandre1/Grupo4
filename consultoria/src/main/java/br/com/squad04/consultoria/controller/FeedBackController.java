package br.com.squad04.consultoria.controller;

import br.com.squad04.consultoria.model.FeedBack;
import br.com.squad04.consultoria.service.ConsultoresService;
import br.com.squad04.consultoria.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping
    public String criarFeedBack(@ModelAttribute FeedBack feedBack) {
        feedBackService.criar(feedBack);
        return "feedback/list";

    }


    @PutMapping("/{id}")
    public String editarFeedBack(@PathVariable Long id, String feedBack) {
        feedBackService.alterar(id, feedBack);
        return "feedback/list";
    }
}
