package app.domain.model;

import java.util.Date;

public class Appointment {
    private String id;
    private String patientId;
    private String doctorId;
    private Date date;

    public Appointment(String id, String patientId, String doctorId, Date date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public Date getDate() { return date; }
}
