package app.infrastructure.persistence.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.ClinicalHistoryEntity;
public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistoryEntity, Long> {
  List<ClinicalHistoryEntity> findByPatientDocumentOrderByDateDesc(int patientDocument);
}
