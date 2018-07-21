package pe.com.upc.tutor.domain.entity;

public class Tutor {

	private long tutorId;
	private String tutorNombre;
	private String tutorApePaterno;
	private String tutorApeMaterno;
	private long tutorDni;
	private String tutorTelefono;
	private boolean isHabilitado;
	public long getTutorId() {
		return tutorId;
	}
	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}
	public String getTutorNombre() {
		return tutorNombre;
	}
	public void setTutorNombre(String tutorNombre) {
		this.tutorNombre = tutorNombre;
	}
	public String getTutorApePaterno() {
		return tutorApePaterno;
	}
	public void setTutorApePaterno(String tutorApePaterno) {
		this.tutorApePaterno = tutorApePaterno;
	}
	public String getTutorApeMaterno() {
		return tutorApeMaterno;
	}
	public void setTutorApeMaterno(String tutorApeMaterno) {
		this.tutorApeMaterno = tutorApeMaterno;
	}
	public long getTutorDni() {
		return tutorDni;
	}
	public void setTutorDni(long tutorDni) {
		this.tutorDni = tutorDni;
	}
	public String getTutorTelefono() {
		return tutorTelefono;
	}
	public void setTutorTelefono(String tutorTelefono) {
		this.tutorTelefono = tutorTelefono;
	}
	public boolean isHabilitado() {
		return isHabilitado;
	}
	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}
	
	
}
