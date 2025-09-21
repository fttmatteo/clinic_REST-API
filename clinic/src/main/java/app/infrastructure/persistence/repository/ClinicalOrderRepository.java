package app.infrastructure.persistence.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Integer> {
  ClinicalOrderEntity findByNumberOrder(int numberOrder);
  List<ClinicalOrderEntity> findByPatientDocument(int patientDocument);
}
