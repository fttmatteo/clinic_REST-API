package app.domain.ports;

import app.domain.model.Appointment;
import java.util.List;

public interface AppointmentPort {
    public Appointment findById(String id) throws Exception;
    public List<Appointment> findByPatient(String patientId) throws Exception;
    public void save(Appointment appointment) throws Exception;
}
