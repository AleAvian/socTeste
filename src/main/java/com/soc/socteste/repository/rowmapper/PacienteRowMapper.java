package com.soc.socteste.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.soc.socteste.model.Paciente;

public class PacienteRowMapper implements RowMapper<Paciente> {

	@Override
	public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Paciente paciente = new Paciente();
		paciente.setId(rs.getInt("id"));
		paciente.setNome(rs.getString("nome"));
		
		return paciente;
	}

}
