package app.adapter.in.builder;

import app.domain.model.DiagnosticAid;

public class DiagnosticAidBuilder {
    private Long diagnosticAidId;
    private String diagnosticAidName;
    private Double price;

    public DiagnosticAidBuilder withDiagnosticAidId(Long v){ this.diagnosticAidId = v; return this; }
    public DiagnosticAidBuilder withDiagnosticAidName(String v){ this.diagnosticAidName = v; return this; }
    public DiagnosticAidBuilder withPrice(Double v){ this.price = v; return this; }

    public DiagnosticAid build(){
        DiagnosticAid x = new DiagnosticAid();
        x.setDiagnosticAidId(diagnosticAidId);
        x.setDiagnosticAidName(diagnosticAidName);
        x.setPrice(price);
        return x;
    }
}
