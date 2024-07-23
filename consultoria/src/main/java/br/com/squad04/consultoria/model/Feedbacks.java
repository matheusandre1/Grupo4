package br.com.squad04.consultoria.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedbacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedback;
    private String feedback;
    private Timestamp dataFeedback;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes idCliente;

    // Getters e Setters

    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Timestamp getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(Timestamp dataFeedback) {
        this.dataFeedback = dataFeedback;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }
}

