package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.Invoice;

public class InvoiceBuilder {
    private Long invoiceId;
    private Date invoiceDate;
    private String patientName;
    private Integer patientAge;
    private Integer patientDocument;
    private String doctorName;
    private String companyName;
    private Long numberPolicy;
    private Integer validityDaysPolicy;
    private Date endDatePolicy;
    private String serviceDescription;
    private String orderReference;
    private Double copayment;
    private Double totalPatient;
    private Double totalInsurance;

    public InvoiceBuilder withInvoiceId(Long v){ this.invoiceId = v; return this; }
    public InvoiceBuilder withInvoiceDate(Date v){ this.invoiceDate = v; return this; }
    public InvoiceBuilder withPatientName(String v){ this.patientName = v; return this; }
    public InvoiceBuilder withPatientAge(Integer v){ this.patientAge = v; return this; }
    public InvoiceBuilder withPatientDocument(Integer v){ this.patientDocument = v; return this; }
    public InvoiceBuilder withDoctorName(String v){ this.doctorName = v; return this; }
    public InvoiceBuilder withCompanyName(String v){ this.companyName = v; return this; }
    public InvoiceBuilder withNumberPolicy(Long v){ this.numberPolicy = v; return this; }
    public InvoiceBuilder withValidityDaysPolicy(Integer v){ this.validityDaysPolicy = v; return this; }
    public InvoiceBuilder withEndDatePolicy(Date v){ this.endDatePolicy = v; return this; }
    public InvoiceBuilder withServiceDescription(String v){ this.serviceDescription = v; return this; }
    public InvoiceBuilder withOrderReference(String v){ this.orderReference = v; return this; }
    public InvoiceBuilder withCopayment(Double v){ this.copayment = v; return this; }
    public InvoiceBuilder withTotalPatient(Double v){ this.totalPatient = v; return this; }
    public InvoiceBuilder withTotalInsurance(Double v){ this.totalInsurance = v; return this; }

    public Invoice build(){
        Invoice x = new Invoice();
        x.setInvoiceId(invoiceId);
        x.setInvoiceDate(invoiceDate);
        x.setPatientName(patientName);
        x.setPatientAge(patientAge);
        x.setPatientDocument(patientDocument);
        x.setDoctorName(doctorName);
        x.setCompanyName(companyName);
        x.setNumberPolicy(numberPolicy);
        x.setValidityDaysPolicy(validityDaysPolicy);
        x.setEndDatePolicy(endDatePolicy);
        x.setServiceDescription(serviceDescription);
        x.setOrderReference(orderReference);
        x.setCopayment(copayment);
        x.setTotalPatient(totalPatient);
        x.setTotalInsurance(totalInsurance);
        return x;
    }
}
