package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.MedicalInsurance;

public class MedicalInsuranceBuilder {
    private String companyName;
    private Long numberPolicy;
    private boolean statusPolicy;
    private Integer validityDaysPolicy;
    private Date endDatePolicy;

    public MedicalInsuranceBuilder withCompanyName(String v){ this.companyName = v; return this; }
    public MedicalInsuranceBuilder withNumberPolicy(Long v){ this.numberPolicy = v; return this; }
    public MedicalInsuranceBuilder withStatusPolicy(boolean v){ this.statusPolicy = v; return this; }
    public MedicalInsuranceBuilder withValidityDaysPolicy(Integer v){ this.validityDaysPolicy = v; return this; }
    public MedicalInsuranceBuilder withEndDatePolicy(Date v){ this.endDatePolicy = v; return this; }

    public MedicalInsurance build(){
        MedicalInsurance x = new MedicalInsurance();
        x.setCompanyName(companyName);
        x.setNumberPolicy(numberPolicy);
        x.setStatusPolicy(statusPolicy);
        x.setValidityDaysPolicy(validityDaysPolicy);
        x.setEndDatePolicy(endDatePolicy);
        return x;
    }
}
