package com.soc.socteste.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.soc.socteste.dto.ExameDTO;
import com.soc.socteste.model.Paciente;
import com.soc.socteste.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.socteste.model.Exame;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private PacienteService pacienteService;

	// - Data do Exame, só pode ser maior que a data atual.

	private boolean exameValido(Exame exame) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataExame = exame.getData().toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		boolean ehValido = dataAtual.isBefore(dataExame) || dataAtual.isEqual(dataExame);
		return ehValido;
	}

	public boolean criarExame(ExameDTO exameDTO) throws ParseException {

		Paciente paciente = exameDTO.getPaciente();
		boolean statusPaciente = pacienteService.criarPaciente(paciente);
		System.out.println(statusPaciente);
		if(statusPaciente){
			paciente = pacienteService.buscarPacientePorNome(paciente.getNome());
			exameDTO.setPaciente(paciente);
			Exame exame = new Exame(exameDTO);
			if(exameValido(exame)){
				int status = exameRepository.criar(exame);
				return status == 1;
			}
		}
		return false;
	}

	public boolean editarExame(Exame exame){
		int status = exameRepository.atualizar(exame);
		return status == 1;
	}

	public boolean deletarExame(int exameId){
		int status = exameRepository.deletar(exameId);
		return status == 1;
	}

	public ExameDTO buscarExame(int exameId){
		Exame exame = exameRepository.buscarId(exameId);
		ExameDTO exameDTO = null;
		if(exame != null){
			exameDTO = new ExameDTO(exame);
			Paciente paciente = pacienteService.buscarPaciente(exame.getPacienteId());
			exameDTO.setPaciente(paciente);
		}
		return exameDTO;
	}

	public List<ExameDTO> buscarListaExames(){
		List<ExameDTO> exames = exameRepository.buscarLista();
		return exames;
	}
}
