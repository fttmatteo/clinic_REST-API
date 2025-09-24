package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.VitalSigns;

public class VitalSignsBuilder {
    private Integer patientDocument;
    private Date registrationDate;
    private String bloodPressure;
    private Double temperature;
    private Integer pulse;
    private Integer oxygenSaturation;

    public VitalSignsBuilder withPatientDocument(Integer v){ this.patientDocument = v; return this; }
    public VitalSignsBuilder withRegistrationDate(Date v){ this.registrationDate = v; return this; }
    public VitalSignsBuilder withBloodPressure(String v){ this.bloodPressure = v; return this; }
    public VitalSignsBuilder withTemperature(Double v){ this.temperature = v; return this; }
    public VitalSignsBuilder withPulse(Integer v){ this.pulse = v; return this; }
    public VitalSignsBuilder withOxygenSaturation(Integer v){ this.oxygenSaturation = v; return this; }

    public VitalSigns build(){
        VitalSigns x = new VitalSigns();
        x.setPatientDocument(patientDocument);
        x.setRegistrationDate(registrationDate);
        x.setBloodPressure(bloodPressure);
        x.setTemperature(temperature);
        x.setPulse(pulse);
        x.setOxygenSaturation(oxygenSaturation);
        return x;
    }
}
