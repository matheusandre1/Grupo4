package br.com.squad04.consultoria.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "nome_empresa", length = 100, nullable = false)
    private String nomeEmpresa;

    @Column(name = "nome_responsavel", length = 100, nullable = false)
    private String nomeResponsavel;

    @Column(name = "cnpj", length = 14, unique = true, nullable = false)
    private String cnpj;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "senha", length = 300, nullable = false)
    private String senha;

    @Column(name = "tipo_de_usuario", length = 9, nullable = false)
    private String tipoDeUsuario;

    @Column(name = "id_consultor", nullable = false)
    private Long idConsultor;


    public Clientes(String nomeEmpresa, String nomeResponsavel, String cnpj,
                    LocalDate dataCadastro, String telefone, String email, String senha,
                    String tipoDeUsuario, Long idConsultor) {

        this.nomeEmpresa = nomeEmpresa;
        this.nomeResponsavel = nomeResponsavel;
        this.cnpj = cnpj;
        this.dataCadastro = dataCadastro;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.tipoDeUsuario = tipoDeUsuario;
        this.idConsultor = idConsultor;
    }

    public Clientes() {
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Long getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Long idConsultor) {
        this.idConsultor = idConsultor;
    }
}
