package br.com.squad04.consultoria.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;
    private Date dataConsulta;
    private String horaConsulta;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes idCliente;
    
    @ManyToOne
    @JoinColumn(name = "id_consultor", nullable = false)
    private Consultores idConsultor;
    
    public Long getIdConsulta() {
        return idConsulta;
    }
    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }
    public Date getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getHoraConsulta() {
        return horaConsulta;
    }
    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
    public Clientes getCliente() {
        return idCliente;
    }
    public void setCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }
    public Consultores getConsultor() {
        return idConsultor;
    }
    public void setConsultor(Consultores idConsultor) {
        this.idConsultor = idConsultor;
    }
}
