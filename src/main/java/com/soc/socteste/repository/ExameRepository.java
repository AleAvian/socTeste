package com.soc.socteste.repository;

import com.soc.socteste.dto.ExameDTO;
import com.soc.socteste.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.soc.socteste.model.Exame;
import com.soc.socteste.repository.rowmapper.ExameRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

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
		try {
			Exame exame = jdbcTemplate.queryForObject(sql, new Object[]{id}, new ExameRowMapper());
			return exame;
		}catch (Exception e){
			return null;
		}
	}

	public List<ExameDTO> buscarLista(){
		String sql = "SELECT p.id as 'pacienteId', p.nome as 'pacienteNome', e.id as 'exameId', " +
				"e.nome as 'exameNome', e.data as 'data', e.resultadoExame as 'resultadoExame' " +
				"FROM exame e " +
				"INNER JOIN paciente p on e.pacienteId = p.id " +
				"ORDER BY p.nome, e.nome";
		try {
			List<ExameDTO> exames = jdbcTemplate.query(sql, new RowMapper<ExameDTO>() {
				@Override
				public ExameDTO mapRow(ResultSet resultSet, int i) throws SQLException {
					ExameDTO exameDTO = new ExameDTO();
					exameDTO.setId(resultSet.getInt("exameId"));
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					String data = formato.format(resultSet.getDate("data"));
					exameDTO.setData(data);
					exameDTO.setNome(resultSet.getString("exameNome"));
					exameDTO.setResultadoExame(resultSet.getString("resultadoExame"));
					Paciente paciente = new Paciente();
					paciente.setId(resultSet.getInt("pacienteId"));
					paciente.setNome(resultSet.getString("pacienteNome"));
					exameDTO.setPaciente(paciente);
					return exameDTO;
				}
			});
			return exames;
		}
		catch (Exception e) {
			return new LinkedList<>();
		}
	}

}
