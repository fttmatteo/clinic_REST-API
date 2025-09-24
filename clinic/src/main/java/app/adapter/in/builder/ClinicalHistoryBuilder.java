package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.ClinicalHistory;

public class ClinicalHistoryBuilder {
    private Integer patientDocument;
    private Date attentionDate;
    private Integer doctorDocument;
    private String motive;
    private String symptoms;
    private String diagnosis;

    public ClinicalHistoryBuilder withPatientDocument(Integer v){ this.patientDocument = v; return this; }
    public ClinicalHistoryBuilder withAttentionDate(Date v){ this.attentionDate = v; return this; }
    public ClinicalHistoryBuilder withDoctorDocument(Integer v){ this.doctorDocument = v; return this; }
    public ClinicalHistoryBuilder withMotive(String v){ this.motive = v; return this; }
    public ClinicalHistoryBuilder withSymptoms(String v){ this.symptoms = v; return this; }
    public ClinicalHistoryBuilder withDiagnosis(String v){ this.diagnosis = v; return this; }

    public ClinicalHistory build(){
        ClinicalHistory x = new ClinicalHistory();
        x.setPatientDocument(patientDocument);
        x.setAttentionDate(attentionDate);
        x.setDoctorDocument(doctorDocument);
        x.setMotive(motive);
        x.setSymptoms(symptoms);
        x.setDiagnosis(diagnosis);
        return x;
    }
}
