package com.soc.socteste.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soc.socteste.model.Paciente;

@Repository
public class PacienteRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//crud
	public int criar (Paciente paciente) {
		int status = jdbcTemplate.update("insert into paciente(nome) values(?)", paciente.getNome());
		return status;
			}
	
	public int atualizar (Paciente paciente) {
		int status = jdbcTemplate.update("update paciente set nome = ? where id = ? ", paciente.getNome(),paciente.getId());
		return status;
			}
	
	
	
}
