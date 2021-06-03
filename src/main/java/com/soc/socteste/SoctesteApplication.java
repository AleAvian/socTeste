package com.soc.socteste;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soc.socteste.model.Paciente;

import repository.PacienteRepository;

@SpringBootApplication
public class SoctesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoctesteApplication.class, args);
		
	}
	
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@PostConstruct 
	public void init() { 
		Paciente paciente = new Paciente();
		paciente.setNome("mane");
		int pacienteId = pacienteRepository.criar(paciente);
	System.out.println(pacienteId);	
		
	}
	
}
