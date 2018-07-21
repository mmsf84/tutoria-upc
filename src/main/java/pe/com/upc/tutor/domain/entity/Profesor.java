package pe.com.upc.tutor.domain.entity;

public class Profesor {

	private long profesorId;
	private String profesorNombre;	
	private boolean isHabilitado;
	public long getProfesorId() {
		return profesorId;
	}
	public void setProfesorId(long profesorId) {
		this.profesorId = profesorId;
	}
	public String getProfesorNombre() {
		return profesorNombre;
	}
	public void setProfesorNombre(String profesorNombre) {
		this.profesorNombre = profesorNombre;
	}
	public boolean isHabilitado() {
		return isHabilitado;
	}
	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}
	
	
}
