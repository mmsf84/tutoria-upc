package pe.com.upc.tutor.domain.entity;

public class AsistenciaTutor {
	private long idTutor;
	private long idCurso;
	private String asistenciaFecha;
	private int tipoActividad;
	private String horaInicio;
	private String horaFin;
	private String aula;
	public long getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(long idTutor) {
		this.idTutor = idTutor;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
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
