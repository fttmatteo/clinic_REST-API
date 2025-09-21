package app.application.usecase;

import app.domain.model.DiagnosticAid;
import app.domain.ports.DiagnosticPort;

public class DiagnosticUseCase {
    private DiagnosticPort diagnosticPort;

    public DiagnosticUseCase(DiagnosticPort diagnosticPort) {
        this.diagnosticPort = diagnosticPort;
    }

    public void saveDiagnostic(DiagnosticAid diagnostic) throws Exception {
        diagnosticPort.save(diagnostic);
    }

    public DiagnosticAid findDiagnosticById(DiagnosticAid diagnostic) throws Exception {
        return diagnosticPort.findById(diagnostic);

    }
}
