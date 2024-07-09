package br.com.squad04.consultoria.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consultores{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultor;
    private String nomeConsultor;
    private String especializacao;
    private String experiencia;
    private String telefone;
    private String email;
    private String senha;
    private Timestamp dataCadastro;

    public Long getIdConsultor() {
        return idConsultor;
    }
    public void setIdConsultor(Long idConsultor) {
        this.idConsultor = idConsultor;
    }

    public String getNomeConsultor() {
        return nomeConsultor;
    }
    public void setNomeConsultor(String nomeConsultor) {
        this.nomeConsultor = nomeConsultor;
    }

    public String getEspecializacao() {
        return especializacao;
    }
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Timestamp getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
