package br.itau.justificativa.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table (name = "itmn232_ocorrencia")
public class Ocorrencia {

    @Id
    @Column(name = "num_seq")
    private int num_seq; //alterado para testar JPA

    /*@Column(name = "id_usuario")
    private int id_usuario; */

   /*  @Column(name = "id_atividade")
    private int id_atividade; */

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_oc", length = 10)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_oc;

    @Column(name = "num_horas", length = 8)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime num_horas;

    @Column(name = "ponto_manual")
    private int ponto_manual;

    @Column(name = "status")
    private int status;

    //Relacionamento com tabela itmn232_usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario") 
    @JsonIgnoreProperties("ocorrencias")
    private Usuario usuario;

    //Relacionamento com tabela itmn232_atividade
    @ManyToOne
    @JoinColumn(name = "id_atividade") 
    @JsonIgnoreProperties("ocorrencias")
    private Atividade atividade;

    public Ocorrencia(){

    }

    public Ocorrencia(int num_seq){
        this.num_seq = num_seq;
    }

       
    //Getters and Setters
    public int getNum_seq() {
        return num_seq;
    }

    public void setNum_seq(int num_seq) {
        this.num_seq = num_seq;
    }

   /*  public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    } */

    /* public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    } */

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_oc() {
        return data_oc;
    }

    public void setData_oc(LocalDate data_oc) {
        this.data_oc = data_oc;
    }

    public LocalTime getNum_horas() {
        return num_horas;
    }

    public void setNum_horas(LocalTime num_horas) {
        this.num_horas = num_horas;
    }

    public int getPonto_manual() {
        return ponto_manual;
    }

    public void setPonto_manual(int ponto_manual) {
        this.ponto_manual = ponto_manual;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
}
