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

import pe.com.upc.tutor.domain.entity.Tutor;
import pe.com.upc.tutor.domain.repository.TutorRepository;

@Repository
public class TutorRepositoryImpl implements TutorRepository {

	private static final Logger log = LogManager.getLogger(TutorRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Tutor findById(long tutorId) throws Exception {
		log.info("Into findById(Long cursoId)");
		String sql = "select t.tutor_id, t.tutor_name from tutor t where t.tutor_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { tutorId }, new RowMapper<Tutor>() {
			public Tutor mapRow(ResultSet rs, int rownum) throws SQLException {
				Tutor tut = new Tutor();
				tut.setTutorId(rs.getLong("tutor_id"));
				tut.setTutorNombre(rs.getString("tutor_name"));
				return tut;
			}
		}); 
	}	 
}
