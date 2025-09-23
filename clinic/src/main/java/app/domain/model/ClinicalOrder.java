package app.domain.model;

import java.sql.Date;

public class ClinicalOrder {
    private Long numberOrder;
    private Integer patientDocument;
    private Integer doctorDocument;
    private Date creationDate;

    public Long getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(Long numberOrder) {
        this.numberOrder = numberOrder;
    }

    public Integer getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(Integer patientDocument) {
        this.patientDocument = patientDocument;
    }

    public Integer getDoctorDocument() {
        return doctorDocument;
    }

    public void setDoctorDocument(Integer doctorDocument) {
        this.doctorDocument = doctorDocument;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    }
