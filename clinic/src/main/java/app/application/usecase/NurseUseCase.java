package app.application.usecase;

import app.domain.model.VitalSigns;
import app.domain.services.CreateVitalSigns;
import app.domain.services.ApplyMedication;
import app.domain.services.RecordProcedure;

public class NurseUseCase {
    private final CreateVitalSigns createVitalSigns;
    private final ApplyMedication applyMedication;
    private final RecordProcedure recordProcedure;

    public NurseUseCase(CreateVitalSigns createVitalSigns,
                        ApplyMedication applyMedication,
                        RecordProcedure recordProcedure) {
        this.createVitalSigns = createVitalSigns;
        this.applyMedication = applyMedication;
        this.recordProcedure = recordProcedure;
    }


    public void registrarSignosVitales(String patientId, double presion, double temperatura, int pulso, double oxigeno) throws Exception {
        VitalSigns vitalSigns = new VitalSigns(patientId, presion, temperatura, pulso, oxigeno);
        createVitalSigns.create(vitalSigns);
    }


    public void registrarMedicamento(String patientId, String medicamento, String dosis) throws Exception {
        applyMedication.create(patientId, medicamento, dosis);
    }


    public void registrarProcedimiento(String patientId, String procedimiento) throws Exception {
        recordProcedure.create(patientId, procedimiento);
    }
}

