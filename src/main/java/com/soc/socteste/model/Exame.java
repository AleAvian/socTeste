package com.soc.socteste.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exame {

	private int id;
	private String nome;
	private Date data;
	private String resultadoExame;
	private Paciente paciente;

}
