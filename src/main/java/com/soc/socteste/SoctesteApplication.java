package com.soc.socteste;

import java.sql.Date;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soc.socteste.model.Exame;
import com.soc.socteste.repository.ExameRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class SoctesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoctesteApplication.class, args);
	}

	@Autowired
	private ExameRepository exameRepository;

	@PostConstruct
	public void init() {
		Exame exame1;
		
		Exame exame = new Exame();
		exame.setId(1);
		exame.setNome("fezes");
		LocalDate localDate = LocalDate.now();
		exame.setData(Date.valueOf(localDate));
		exame.setResultadoExame("qq coisa");
		exame.setPacienteId(3);
		exame1 = exameRepository.buscarId(1);
		System.out.println(exame1.getNome() + " " + exame1.getResultadoExame());
		
		
		
	

	}
}
