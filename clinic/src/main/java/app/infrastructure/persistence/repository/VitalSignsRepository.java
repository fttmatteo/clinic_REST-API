package app.infrastructure.persistence.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.VitalSignsEntity;
import app.infrastructure.persistence.entities.VitalSignsKey;
public interface VitalSignsRepository extends JpaRepository<VitalSignsEntity, VitalSignsKey> {
  List<VitalSignsEntity> findById_PatientDocumentOrderById_DateAsc(int patientDocument);
}
