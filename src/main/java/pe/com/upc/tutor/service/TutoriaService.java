package pe.com.upc.tutor.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pe.com.upc.common.application.Notification;
import pe.com.upc.tutor.domain.entity.Curso;
import pe.com.upc.tutor.domain.entity.Tutor;

@Service
public class TutoriaService {

	public void performAsistencia(Curso curso, Tutor tutor, String fecha, int tipoActividad, 
			String horaInicio,	String horaFin, String aula)
			throws IllegalArgumentException {
		Notification notification = this.validation(fecha,tipoActividad,horaInicio,horaFin,aula);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
	}
	
	private Notification validation(String fecha, int tipoActividad,String horaInicio,	
			String horaFin, String aula) {
        Notification notification = new Notification();
        this.validateFecha(notification, fecha);
        this.validateAct(notification, tipoActividad);
        this.validateHoras(notification, horaInicio, horaFin);
        this.validateAula(notification, aula);
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
}
