package app.adapter.in.rest.request;

public class InvoiceRequest {
    private String patientDocument;
    private String doctorName;
    private String serviceDescription;
    private String totalService;
    private String invoiceDate;   

    public InvoiceRequest() {}

    public String getPatientDocument() { return patientDocument; }
    public void setPatientDocument(String patientDocument) { this.patientDocument = patientDocument; }
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public String getServiceDescription() { return serviceDescription; }
    public void setServiceDescription(String serviceDescription) { this.serviceDescription = serviceDescription; }
    public String getTotalService() { return totalService; }
    public void setTotalService(String totalService) { this.totalService = totalService; }
    public String getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(String invoiceDate) { this.invoiceDate = invoiceDate; }
}
