package app.domain.model;

public class ProcedureRecord {
    private String patientId;
    private String procedimiento;

    public ProcedureRecord(String patientId, String procedimiento) {
        this.patientId = patientId;
        this.procedimiento = procedimiento;
    }

    public String getPatientId() { return patientId; }
    public String getProcedimiento() { return procedimiento; }
}
