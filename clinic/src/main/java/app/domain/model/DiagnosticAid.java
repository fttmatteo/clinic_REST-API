package app.domain.model;

public class DiagnosticAid {
    private Long diagnosticAidId;
    private String diagnosticAidName;
    private Double price;

    public Long getDiagnosticAidId() {
        return diagnosticAidId;
    }

    public void setDiagnosticAidId(Long diagnosticAidId) {
        this.diagnosticAidId = diagnosticAidId;
    }

    public String getDiagnosticAidName() {
        return diagnosticAidName;
    }

    public void setDiagnosticAidName(String diagnosticAidName) {
        this.diagnosticAidName = diagnosticAidName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    }
