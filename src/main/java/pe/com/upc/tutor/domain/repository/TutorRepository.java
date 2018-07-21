package pe.com.upc.tutor.domain.repository;

import pe.com.upc.tutor.domain.entity.Tutor;

public interface TutorRepository {

	Tutor findById(long tutorId) throws Exception;
	//void save(Tutor tutor);
}
