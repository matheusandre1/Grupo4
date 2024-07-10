package br.com.squad04.consultoria.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name ="relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idConsulta")
    private Consultas consulta;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "idConsultor")
    private Consultores consultor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consultas getConsulta() {
        return consulta;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Consultores getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultores consultor) {
        this.consultor = consultor;
    }
}
