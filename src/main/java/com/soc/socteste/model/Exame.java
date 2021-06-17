package com.soc.socteste.model;

import com.soc.socteste.dto.ExameDTO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exame {

	public Exame(){

	}

	public Exame(ExameDTO exameDTO) throws ParseException {
		this.id = exameDTO.getId();
		this.nome = exameDTO.getNome();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		this.data = formato.parse(exameDTO.getData());
		this.resultadoExame = exameDTO.getResultadoExame();
		this.pacienteId = exameDTO.getPaciente().getId();
	}

	private Integer id;
	private String nome;
	private Date data;
	private String resultadoExame;
	private int pacienteId;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getResultadoExame() {
		return resultadoExame;
	}

	public void setResultadoExame(String resultadoExame) {
		this.resultadoExame = resultadoExame;
	}

	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

}
