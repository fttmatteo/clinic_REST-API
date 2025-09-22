package app.infrastructure.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.PatientEntity;
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
  PatientEntity findByDocument(int document);
  PatientEntity findByEmail(String email);
}
