package pe.com.upc.tutor.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.upc.common.api.controller.ResponseHandler;
import pe.com.upc.tutor.application.TutorApplicationService;
import pe.com.upc.tutor.application.dto.TutorAsistenciaDto;
import pe.com.upc.tutor.application.dto.AlumnoRegDto;
import pe.com.upc.tutor.application.dto.AlumnoTallerAsisteDto;
import pe.com.upc.tutor.application.dto.ConsultaAlumnoRegDto;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(value = "*")
public class TutoriaController {
	private static final Logger log = LogManager.getLogger(TutoriaController.class);

	@Autowired
	private TutorApplicationService tutorApplicationService;
	
	@Autowired
	ResponseHandler responseHandler;	
	
	@GetMapping(path = "/info")
	public String info() {
		return "Servicio Activo";
	}
  
	@PostMapping(
			value = "/asistenciaTutor", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> peformAsistenciaTutor(@RequestBody TutorAsistenciaDto reqTutorAsistenciaDto) throws Exception {
		try {
			tutorApplicationService.performAsistenciaTutor(reqTutorAsistenciaDto);
			return this.responseHandler.getCommandResponse(HttpStatus.CREATED, "Asistencia de Tutor marcada!");
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}

	@PostMapping(
			value = "/asistenciaAlumno", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Object> peformAsistenciaAlumno(@RequestBody AlumnoTallerAsisteDto reqAlumnoAsistenciaDto) throws Exception {
		try {
			tutorApplicationService.performAsistenciaAlumno(reqAlumnoAsistenciaDto);
			return this.responseHandler.getCommandResponse(HttpStatus.CREATED,"Asistencia de Alumnos marcada!");
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
  
	@GetMapping(
			value = "/consultaAlumnoReg", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Object> selectAlumnoReg(@RequestBody ConsultaAlumnoRegDto reqConsultaAlumnoDto) throws Exception {
		try {
			List<AlumnoRegDto> resul = tutorApplicationService.getAlumnoReg(reqConsultaAlumnoDto); 
			return this.responseHandler.getDataResponse(resul, HttpStatus.OK);
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
}
