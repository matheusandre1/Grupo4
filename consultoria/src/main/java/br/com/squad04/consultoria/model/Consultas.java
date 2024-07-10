package br.com.squad04.consultoria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_consultor", nullable = false)
    private Consultores consultor;

    private LocalDateTime dataHora;
    private String status;

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void definirDataHoraAtual() {
        this.dataHora = LocalDateTime.now();
    }
}
