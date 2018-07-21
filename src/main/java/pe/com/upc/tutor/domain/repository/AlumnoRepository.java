package pe.com.upc.tutor.domain.repository;

import pe.com.upc.tutor.domain.entity.Alumno;

public interface AlumnoRepository {
	Alumno findByCod(long alumnoId) throws Exception;

}
