package pe.com.upc.tutor.domain.repository;

import pe.com.upc.tutor.domain.entity.Alumno;
import pe.com.upc.tutor.domain.entity.Curso;
import pe.com.upc.tutor.domain.entity.Profesor;
import pe.com.upc.tutor.domain.entity.Tutor;

public interface AsisTutorRepository {
	void saveAsisTutor(Tutor tutor, Curso curso, String asistenciaFecha, int tipoActividad, String horaInicio,
			String horaFin, String aula);
	
	void saveAsisAlumno(Tutor tutor, Curso curso, Profesor profesor, Alumno alumno, String fecha,
			String horaInicio, String seccion);
}
