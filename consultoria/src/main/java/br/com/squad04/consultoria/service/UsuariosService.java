package br.com.squad04.consultoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Usuarios;
import br.com.squad04.consultoria.repository.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios autenticar(String usuario, String senha){
        Usuarios user = usuariosRepository.findByUsuario(usuario);
        if(user != null && user.getSenha().equals(senha)){
            return user;
        }
        return null;
    }
}
