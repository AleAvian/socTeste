package com.soc.socteste.dto;

import java.text.SimpleDateFormat;

import com.soc.socteste.model.Exame;
import com.soc.socteste.model.Paciente;

public class ExameDTO {

    private Integer id;
    private String nome;
    private String data;
    private String resultadoExame;
    private Paciente paciente;

    public ExameDTO(){

    }

    public ExameDTO(Exame exame){
        this.id = exame.getId();
        this.nome = exame.getNome();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.data = formato.format(exame.getData());
        this.resultadoExame = exame.getResultadoExame();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(String resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
