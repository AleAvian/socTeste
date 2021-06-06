package com.soc.socteste;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soc.socteste.model.Paciente;
import com.soc.socteste.repository.PacienteRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class SoctesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoctesteApplication.class, args);
	}

	@Autowired
	private PacienteRepository pacienteRepository;

	@PostConstruct
	public void init() {
		Paciente paciente = new Paciente();
		paciente.setId(3);
		paciente.setNome("Alessandro");
		int status = pacienteRepository.atualizar(paciente);

	}
}
