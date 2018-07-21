package pe.com.upc.tutor.domain.repository;

import pe.com.upc.tutor.domain.entity.Curso;

public interface CursoRepository {
	Curso findById(long cursoId) throws Exception;
	//void save(Curso curso);

}
