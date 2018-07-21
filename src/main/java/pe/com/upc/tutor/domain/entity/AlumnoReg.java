package pe.com.upc.tutor.domain.entity;

public class AlumnoReg {

	private String alumnoNombre;
	private int cntAsistencia;
	private String carrera;
	private String hora;
	private String sede;
	private String curso;
	
	public String getAlumnoNombre() {
		return alumnoNombre;
	}
	public void setAlumnoNombre(String alumnoNombre) {
		this.alumnoNombre = alumnoNombre;
	}
	public int getCntAsistencia() {
		return cntAsistencia;
	}
	public void setCntAsistencia(int cntAsistencia) {
		this.cntAsistencia = cntAsistencia;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
