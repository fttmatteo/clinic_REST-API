package app.domain.services;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;

public class CreateAppointment {
    private final AppointmentPort appointmentPort;

    public CreateAppointment(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public void create(Appointment appointment) throws Exception {
        if (appointment.getId() == null || appointment.getId().isEmpty()) {
            throw new Exception("El ID de la cita es obligatorio");
        }
        if (appointment.getPatientId() == null || appointment.getPatientId().isEmpty()) {
            throw new Exception("El paciente es obligatorio");
        }
        if (appointment.getDoctorId() == null || appointment.getDoctorId().isEmpty()) {
            throw new Exception("El médico es obligatorio");
        }
        if (appointment.getDate() == null) {
            throw new Exception("La fecha de la cita es obligatoria");
        }


        Appointment existing = appointmentPort.findById(appointment.getId());
        if (existing != null) {
            throw new Exception("Ya existe una cita con este ID");
        }

        appointmentPort.save(appointment);
    }
}
