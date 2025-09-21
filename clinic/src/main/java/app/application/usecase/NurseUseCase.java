package app.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.VitalSigns;
import app.domain.ports.VitalSignsPort;
import app.domain.services.RecordVitalSigns;

@Service
public class NurseUseCase {

    @Autowired
    private RecordVitalSigns recordVitalSigns;

    @Autowired
    private VitalSignsPort vitalSignsPort;

    public void recordVitalSigns(VitalSigns vitalSigns) throws Exception {
        recordVitalSigns.create(vitalSigns);
    }

    public List<VitalSigns> listVitalSignsByPatient(int patientDocument) throws Exception {
        return vitalSignsPort.listByPatient(patientDocument);
    }
}
