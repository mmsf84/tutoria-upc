package pe.com.upc.tutor.application.dto;

import pe.com.upc.common.application.dto.RequestBaseDto;

public class TutorAsistenciaDto extends RequestBaseDto{

	private long tutorId;
	private long cursoId;
	private String asistenciaFecha;
	private int tipoActividad;
	private String horaInicio;
	private String horaFin;
	private String aula;
	public long getTutorId() {
		return tutorId;
	}
	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}
	public long getCursoId() {
		return cursoId;
	}
	public void setCursoId(long cursoId) {
		this.cursoId = cursoId;
	}
	public String getAsistenciaFecha() {
		return asistenciaFecha;
	}
	public void setAsistenciaFecha(String asistenciaFecha) {
		this.asistenciaFecha = asistenciaFecha;
	}
	public int getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(int tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	
	
	
	
	}
