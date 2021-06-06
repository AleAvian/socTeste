package com.soc.socteste.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soc.socteste.model.Paciente;
import com.soc.socteste.repository.rowmapper.PacienteRowMapper;

@Repository
public class PacienteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// crud
	public int criar(Paciente paciente) {
		int status = jdbcTemplate.update("insert into paciente(nome) values(?)", paciente.getNome());
		return status;
	}

	public int atualizar(Paciente paciente) {
		int status = jdbcTemplate.update("update paciente set nome = ? where id = ? ", paciente.getNome(),
				paciente.getId());
		return status;
	}

	public int deletar(int id) {
		int status = jdbcTemplate.update("delete from paciente where id = ? ", id);
		return status;
	}

	@SuppressWarnings("deprecation")
	public Paciente buscarId(int id) {
		String sql = "select *from paciente where id = ?";
		Paciente paciente = jdbcTemplate.queryForObject(sql, new Object[] { id }, new PacienteRowMapper());
		return paciente;

	}

}
