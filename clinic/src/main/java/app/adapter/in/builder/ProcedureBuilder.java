package app.adapter.in.builder;

import app.domain.model.Procedure;

public class ProcedureBuilder {
    private Long procedureId;
    private String procedureName;
    private Double price;

    public ProcedureBuilder withProcedureId(Long v){ this.procedureId = v; return this; }
    public ProcedureBuilder withProcedureName(String v){ this.procedureName = v; return this; }
    public ProcedureBuilder withPrice(Double v){ this.price = v; return this; }

    public Procedure build(){
        Procedure x = new Procedure();
        x.setProcedureId(procedureId);
        x.setProcedureName(procedureName);
        x.setPrice(price);
        return x;
    }
}
