package pe.com.upc.tutor.domain.infrastructure.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.com.upc.tutor.domain.entity.Curso;
import pe.com.upc.tutor.domain.repository.CursoRepository;


@Repository
public class CursoRepositoryImpl implements CursoRepository {

	private static final Logger log = LogManager.getLogger(CursoRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Curso findById(long cursoId) throws Exception {
		log.info("Into findById(Long cursoId)");
		String sql = "select c.curso_id, c.curso_name from curso c where c.curso_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { cursoId }, new RowMapper<Curso>() {
			public Curso mapRow(ResultSet rs, int rownum) throws SQLException {
				Curso cur = new Curso();
				cur.setCursoId(rs.getLong("curso_id"));
				cur.setCursoNombre(rs.getString("curso_name"));
				return cur;
			}
		}); 
	}	 
}
