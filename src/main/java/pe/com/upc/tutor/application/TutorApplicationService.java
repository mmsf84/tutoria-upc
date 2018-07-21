package pe.com.upc.tutor.application;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.upc.common.application.Notification;
import pe.com.upc.common.application.dto.RequestBaseDto;
import pe.com.upc.common.application.enumeration.RequestBodyType;
import pe.com.upc.tutor.application.dto.AlumnoRegDto;
import pe.com.upc.tutor.application.dto.AlumnoTallerAsisteDto;
import pe.com.upc.tutor.application.dto.ConsultaAlumnoRegDto;
import pe.com.upc.tutor.application.dto.TutorAsistenciaDto;
import pe.com.upc.tutor.domain.entity.Alumno;
import pe.com.upc.tutor.domain.entity.AlumnoReg;
import pe.com.upc.tutor.domain.entity.Curso;
import pe.com.upc.tutor.domain.entity.Profesor;
import pe.com.upc.tutor.domain.entity.Tutor;
import pe.com.upc.tutor.domain.repository.AlumnoRegRepository;
import pe.com.upc.tutor.domain.repository.AlumnoRepository;
import pe.com.upc.tutor.domain.repository.AsisTutorRepository;
import pe.com.upc.tutor.domain.repository.CursoRepository;
import pe.com.upc.tutor.domain.repository.ProfesorRepository;
import pe.com.upc.tutor.domain.repository.TutorRepository;

@Service
public class TutorApplicationService {
	private static final Logger log = LogManager.getLogger(TutorApplicationService.class);
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsisTutorRepository asisTutorRepository;
	
	@Autowired
	private AlumnoRegRepository alumnoRegRepository;
	
	public void performAsistenciaTutor(TutorAsistenciaDto reqTutorAsistenciaDto) throws Exception {
		log.info("Into performAsistenciaTutor(TutorAsistenciaDto reqTutorAsistenciaDto)");
		
		Notification notification = this.validation(reqTutorAsistenciaDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
        
        Tutor tutor = this.tutorRepository.findById(reqTutorAsistenciaDto.getTutorId());
		Curso curso = this.cursoRepository.findById(reqTutorAsistenciaDto.getCursoId());
		this.validateFecha(notification, reqTutorAsistenciaDto.getAsistenciaFecha());
        this.validateAct(notification, reqTutorAsistenciaDto.getTipoActividad());
        this.validateHoras(notification, reqTutorAsistenciaDto.getHoraInicio(), reqTutorAsistenciaDto.getHoraFin());
        this.validateAula(notification, reqTutorAsistenciaDto.getAula());
		this.asisTutorRepository.saveAsisTutor(tutor, curso, reqTutorAsistenciaDto.getAsistenciaFecha(),
				reqTutorAsistenciaDto.getTipoActividad(), reqTutorAsistenciaDto.getHoraInicio(), 
				reqTutorAsistenciaDto.getHoraFin(), reqTutorAsistenciaDto.getAula());
	}
	
	public void performAsistenciaAlumno(AlumnoTallerAsisteDto reqAlumnoAsistenciaDto) throws Exception {
		log.info("Into performAsistenciaAlumno(AlumnoTallerAsisteDto reqAlumnoAsistenciaDto)");
		Notification notification = this.validation(reqAlumnoAsistenciaDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
        
        Tutor tutor = this.tutorRepository.findById(reqAlumnoAsistenciaDto.getTutorId());
		Curso curso = this.cursoRepository.findById(reqAlumnoAsistenciaDto.getCursoId());
		Profesor profesor = this.profesorRepository.findById(reqAlumnoAsistenciaDto.getProfesorId());
		Alumno alumno = this.alumnoRepository.findByCod(reqAlumnoAsistenciaDto.getAlumnoCod());
		this.validateFecha(notification, reqAlumnoAsistenciaDto.getActividadFecha());        
		this.asisTutorRepository.saveAsisAlumno(tutor, curso, profesor, alumno, reqAlumnoAsistenciaDto.getActividadFecha(),
				reqAlumnoAsistenciaDto.getHoraInicio(), reqAlumnoAsistenciaDto.getSeccion());
	}
	
	public List<AlumnoRegDto> getAlumnoReg(ConsultaAlumnoRegDto selectAlumnoAsistenciaDto) throws Exception {
		log.info("Into getAlumnoReg(ConsultaAlumnoRegDto selectAlumnoAsistenciaDto)");
		
		Notification notification = this.validation(selectAlumnoAsistenciaDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }        
		List<AlumnoReg> regs = this.alumnoRegRepository.findByCriterio(selectAlumnoAsistenciaDto.getSedeId(),
				selectAlumnoAsistenciaDto.getMes(), selectAlumnoAsistenciaDto.getSemestre(), 
				selectAlumnoAsistenciaDto.getCursoId());
		return this.builderAlumnoRegDto(regs);
	}
	
	private Notification validation(RequestBaseDto requestDto) {
		Notification notification = new Notification();
		if (requestDto == null || requestDto.getRequestBodyType() == RequestBodyType.INVALID) {
			notification.addError("JSON invalido en el request.");
		}
		return notification;
	}
		
	private void validateFecha(Notification notification, String fecha) {
        if (fecha == null) {
            notification.addError("Debe consignar una Fecha");
            return;
        }
    }
    
	private void validateAct(Notification notification, int tipoActividad) {
        if (tipoActividad < 0) {
            notification.addError("El tipo de actividad no es válido");
            return;
        }
    }
	
    private void validateHoras(Notification notification, String horaInicio, String horaFin) {
        if (horaInicio == null || horaFin == null) {
            notification.addError("El rango de horas no es válido");
            return;
        }
        /*if (horaFin.getNumber().equals(destinationAccount.getNumber())) {
            notification.addError("Cannot transfer money to the same bank account");
        }*/
    }
    
    private void validateAula(Notification notification, String aula) {
    	if (aula == null) {
            notification.addError("Debe consignar un Aula");
            return;
        }
    }
    
    private List<AlumnoRegDto> builderAlumnoRegDto(List<AlumnoReg> regs){
		log.info("Into builderAlumnoRegDto(List<AlumnoReg> regs)");
		List<AlumnoRegDto> regsDto = new ArrayList<>();
		for (AlumnoReg ar : regs) {
			AlumnoRegDto ard = new AlumnoRegDto();
			ard.setAlumnoNombre(ar.getAlumnoNombre());
			ard.setCntAsistencia(ar.getCntAsistencia());
			ard.setCarrera(ar.getCarrera());
			ard.setHora(ar.getHora());
			ard.setSede(ar.getSede());
			ard.setCurso(ar.getCurso());
			regsDto.add(ard);
		}
		return regsDto;
	}
}