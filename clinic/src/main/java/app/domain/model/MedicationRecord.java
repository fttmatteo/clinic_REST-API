package app.domain.model;

public class MedicationRecord {
    private String patientId;
    private String medicamento;
    private String dosis;

    public MedicationRecord(String patientId, String medicamento, String dosis) {
        this.patientId = patientId;
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    public String getPatientId() { return patientId; }
    public String getMedicamento() { return medicamento; }
    public String getDosis() { return dosis; }
}
