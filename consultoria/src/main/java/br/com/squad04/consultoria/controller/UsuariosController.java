package br.com.squad04.consultoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.squad04.consultoria.model.Usuarios;
import br.com.squad04.consultoria.service.UsuariosService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticar(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha, HttpSession session, Model model){
        Usuarios user =usuariosService.autenticar(usuario, senha);
        if(user != null){
            session.setAttribute("usuarioLogado", user);
            return "redirect:/home";
        }else{
            model.addAttribute("erro", "Usuario ou senha Inválido");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuarioLogado", usuarioLogado);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }  
}
