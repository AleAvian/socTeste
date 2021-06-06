package com.soc.socteste.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.soc.socteste.model.Exame;

public class ExameRowMapper implements RowMapper<Exame>{
	
	@Override
	public Exame mapRow(ResultSet rs, int rowNum) throws SQLException {
		Exame exame = new Exame();
		exame.setId(rs.getInt("id"));
		exame.setNome(rs.getString("nome"));
		exame.setData(rs.getDate("data"));
		exame.setResultadoExame(rs.getString("resultadoExame"));
		exame.setPacienteId(rs.getInt("pacienteId"));
		
		return exame;
	}
	

}
