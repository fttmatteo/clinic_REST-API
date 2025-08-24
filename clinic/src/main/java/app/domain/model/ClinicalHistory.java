package app.domain.model;

import java.sql.Date;

public class ClinicalHistory {
    private Date date;
    private Employee document;
    private String motive;
    private String symptoms;
    private String diagnosis;
    private String medicine;
    private String procedure;
    private String diagnosticHelp;
    private String orderNo;
    private String elementId;
    private String dose;
    private String duration;
    private int quantity;
    private String frequency;
    private boolean specialist;
    private String specialty;
    private ClinicalOrder id;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getdocument() {
        return document;
    }
    public void setdocument(Employee document) {
        this.document = document;
    }

    public String getMotive() {
        return motive;
    }
    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getProcedure() {
        return procedure;
    }
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getDiagnosticHelp() {
        return diagnosticHelp;
    }
    public void setDiagnosticHelp(String diagnosticHelp) {
        this.diagnosticHelp = diagnosticHelp;
    }

    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getElementId() {
        return elementId;
    }
    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getDose() {
        return dose;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isSpecialist() {
        return specialist;
    }
    public void setSpecialist(boolean specialist) {
        this.specialist = specialist;
    }

    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ClinicalOrder getid() {
        return id;
    }
    public void setid(ClinicalOrder id) {
        this.id = id;
    }
}
