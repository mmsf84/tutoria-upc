package pe.com.upc.tutor.application.dto;

import pe.com.upc.common.application.dto.RequestBaseDto;

public class ConsultaAlumnoRegDto extends RequestBaseDto {

	private int sedeId;
	private int mes;
	private String semestre;
	private long cursoId;
	
	public int getSedeId() {
		return sedeId;
	}
	public void setSedeId(int sedeId) {
		this.sedeId = sedeId;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public long getCursoId() {
		return cursoId;
	}
	public void setCursoId(long cursoId) {
		this.cursoId = cursoId;
	}
	
	
}
