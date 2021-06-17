package com.soc.socteste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.soc.socteste.model.Paciente;
import com.soc.socteste.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;

	// - O nome do paciente deverá ser único.

	private boolean ehNomeUnico(String nome, Integer id) {
		Paciente paciente = pacienteRepository.findByNome(nome);
		if (paciente == null || paciente.getId() == id) {
			System.out.println("Pode inserir/editar paciente");
			return true;
		} else {
			System.out.println("Erro! Paciente existente");
			return false;
		}

	}
	
	public boolean criarPaciente (Paciente paciente) {
		if(this.ehNomeUnico(paciente.getNome(), null) == true) {
			int status = pacienteRepository.criar(paciente);
			return status == 1;
		}
		return false;
	}

	public Paciente buscarPacientePorNome(String nome){
		return pacienteRepository.findByNome(nome);
	}

	public boolean editarPaciente(Paciente paciente){
		if(this.ehNomeUnico(paciente.getNome(), paciente.getId())){
			int status = pacienteRepository.atualizar(paciente);
			return status == 1;
		}
		return false;
	}

	public boolean deletarPaciente(int idPaciente){
		int status = pacienteRepository.deletar(idPaciente);
		return status == 1;
	}

	public Paciente buscarPaciente(int idPaciente){
		Paciente paciente = pacienteRepository.buscarId(idPaciente);
		return paciente;
	}

}
