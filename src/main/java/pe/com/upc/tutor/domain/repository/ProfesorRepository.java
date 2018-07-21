package pe.com.upc.tutor.domain.repository;

import pe.com.upc.tutor.domain.entity.Profesor;

public interface ProfesorRepository {
	Profesor findById(long profesorId) throws Exception;
	//void save(Curso curso);

}
