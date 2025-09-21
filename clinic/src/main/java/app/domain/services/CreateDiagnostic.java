package app.domain.services;

import app.domain.model.DiagnosticAid;
import app.domain.ports.DiagnosticPort;

public class CreateDiagnostic {
    private DiagnosticPort diagnosticPort;

    public void create(DiagnosticAid diagnostic) throws Exception {
        if (diagnostic == null) {
            throw new Exception("El diagnóstico es nulo");
        }
        diagnosticPort.save(diagnostic);
    }
}
