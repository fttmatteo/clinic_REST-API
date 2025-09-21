package app.domain.ports;

import app.domain.model.DiagnosticAid;

public interface DiagnosticPort {
    DiagnosticAid findById(DiagnosticAid diagnostic) throws Exception;
    void save(DiagnosticAid diagnostic) throws Exception;
}
