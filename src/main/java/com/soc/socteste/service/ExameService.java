package com.soc.socteste.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.soc.socteste.model.Exame;

@Service
public class ExameService {

	// - Data do Exame, só pode ser maior que a data atual.

	private boolean exameValido(Exame exame) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataExame = exame.getData().toLocalDate();
		boolean ehValido = dataAtual.isBefore(dataExame) || dataAtual.isEqual(dataExame);
		return ehValido;

	}
	
	

}
