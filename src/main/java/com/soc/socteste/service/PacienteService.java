package com.soc.socteste.service;

import org.springframework.stereotype.Service;

import com.soc.socteste.model.Paciente;
import com.soc.socteste.repository.PacienteRepository;

@Service
public class PacienteService {

	private PacienteRepository pacienteRepository;

	// - O nome do paciente deverá ser único.

	private boolean nomeUnico(String nome) {
		Paciente paciente = pacienteRepository.findByNome(nome);
		if (paciente == null) {
			System.out.println(" Novo paciente inserido");
			return true;
		} else {
			System.out.println("Erro! Paciente existente");
			return false;
		}

	}
	
	public boolean novoPaciente (Paciente paciente) {
		if(this.nomeUnico(paciente.getNome()) == true) {
		pacienteRepository.criar(paciente);
				}
		return true;	
		
	}
}
