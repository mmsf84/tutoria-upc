package pe.com.upc.tutor.domain.repository;

import java.util.List;

import pe.com.upc.tutor.domain.entity.AlumnoReg;

public interface AlumnoRegRepository {
	List<AlumnoReg> findByCriterio(int sedeId, int mes, String semestre, long cursoId);
}
