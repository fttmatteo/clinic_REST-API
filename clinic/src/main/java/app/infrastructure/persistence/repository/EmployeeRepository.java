package app.infrastructure.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.EmployeeEntity;
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  EmployeeEntity findByDocument(int document);
  EmployeeEntity findByUsername(String username);
  void deleteByDocument(int document);
}
