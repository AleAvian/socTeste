package com.soc.socteste.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soc.socteste.model.Exame;
import com.soc.socteste.repository.rowmapper.ExameRowMapper;

@Repository
public class ExameRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// crud
	public int criar(Exame exame) {
		int status = jdbcTemplate.update("insert into exame(nome, data,resultadoExame,pacienteId) values(? , ?, ?, ?)",
				exame.getNome(), exame.getData(), exame.getResultadoExame(), exame.getPacienteId());
		return status;
	}

	public int atualizar(Exame exame) {
		int status = jdbcTemplate.update(
				"update exame set nome = ?, data = ?, resultadoExame = ?, pacienteId = ? where id = ? ", exame.getNome(),
				exame.getData(), exame.getResultadoExame(), exame.getPacienteId(), exame.getId());
		return status;
	}

	public int deletar(int id) {
		int status = jdbcTemplate.update("delete from exame where id = ? ", id);
		return status;
	}

	@SuppressWarnings("deprecation")
	public Exame buscarId(int id) {
		String sql = "select *from exame where id = ?";
		Exame exame = jdbcTemplate.queryForObject(sql, new Object[] { id }, new ExameRowMapper());
		return exame;

	}

}
