package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.soc.socteste.model.Paciente;


@Component
public class PacienteRepository {
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//crud
	public int criar (Paciente paciente) {
		int pacienteId = jdbcTemplate.update("insert into paciente(nome) values(?)", paciente.getNome());
		return pacienteId;
		
	}
	

}
