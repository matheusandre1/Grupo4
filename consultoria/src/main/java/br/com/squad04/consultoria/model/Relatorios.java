package br.com.squad04.consultoria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Relatorios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelatorio;
    private String relatorio;
    
    @ManyToOne
    @JoinColumn(name = "id_consultor", nullable = false)
    private Consultores idConsultor;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes idCliente;
    
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consultas idConsulta;

    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Consultores getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Consultores idConsultor) {
        this.idConsultor = idConsultor;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Consultas getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consultas idConsulta) {
        this.idConsulta = idConsulta;
    }
 
}
