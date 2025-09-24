package app.adapter.in.builder;

import app.domain.model.Specialist;

public class SpecialistBuilder {
    private Long specialistId;
    private String specialistName;

    public SpecialistBuilder withSpecialistId(Long v){ this.specialistId = v; return this; }
    public SpecialistBuilder withSpecialistName(String v){ this.specialistName = v; return this; }

    public Specialist build(){
        Specialist x = new Specialist();
        x.setSpecialistId(specialistId);
        x.setSpecialistName(specialistName);
        return x;
    }
}
