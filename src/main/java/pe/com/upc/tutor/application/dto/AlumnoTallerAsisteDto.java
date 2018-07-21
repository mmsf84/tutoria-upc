package pe.com.upc.tutor.application.dto;

import java.util.List;

import pe.com.upc.common.application.dto.RequestBaseDto;


public class AlumnoTallerAsisteDto extends RequestBaseDto{

	private long cursoId;	
	private String actividadFecha;
	private String horaInicio;
	private long tutorId;
	private long alumnoCod;
	private long profesorId;
	private String seccion;
	public long getCursoId() {
		return cursoId;
	}
	public void setCursoId(long cursoId) {
		this.cursoId = cursoId;
	}
	public String getActividadFecha() {
		return actividadFecha;
	}
	public void setActividadFecha(String actividadFecha) {
		this.actividadFecha = actividadFecha;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public long getTutorId() {
		return tutorId;
	}
	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}
	public long getAlumnoCod() {
		return alumnoCod;
	}
	public void setAlumnoCod(long alumnoCod) {
		this.alumnoCod = alumnoCod;
	}
	public long getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(long profesorId) {
		this.profesorId = profesorId;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	
	
	
	}
