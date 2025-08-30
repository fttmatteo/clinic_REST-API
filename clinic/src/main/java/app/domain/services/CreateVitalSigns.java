package app.domain.services;

import app.domain.model.VitalSigns;
import app.domain.ports.VitalSignsPort;

public class CreateVitalSigns {
    private final VitalSignsPort vitalSignsPort;

    public CreateVitalSigns(VitalSignsPort vitalSignsPort) {
        this.vitalSignsPort = vitalSignsPort;
    }

    public void create(VitalSigns vitalSigns) throws Exception {
        if (vitalSigns.getPatientId() == null || vitalSigns.getPatientId().isEmpty()) {
            throw new Exception("El paciente es obligatorio");
        }
        if (vitalSigns.getPressure() <= 0) {
            throw new Exception("La presión debe ser válida");
        }
        if (vitalSigns.getTemperature() <= 0) {
            throw new Exception("La temperatura debe ser válida");
        }
        if (vitalSigns.getPulse() <= 0) {
            throw new Exception("El pulso debe ser válido");
        }


        vitalSignsPort.save(vitalSigns);
    }
}
