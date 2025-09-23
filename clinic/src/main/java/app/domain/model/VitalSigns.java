package app.domain.model;

import java.sql.Date;

public class VitalSigns {
    private Integer patientDocument;
    private Date registrationDate;
    private String bloodPressure;
    private Double temperature;
    private Integer pulse;
    private Integer oxygenSaturation;

    public Integer getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Integer patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(Integer oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }
}
