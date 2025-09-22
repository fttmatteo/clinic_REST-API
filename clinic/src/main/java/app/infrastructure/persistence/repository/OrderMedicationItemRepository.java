package app.infrastructure.persistence.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.OrderMedicationItemEntity;
import app.infrastructure.persistence.entities.OrderMedicationItemKey;
public interface OrderMedicationItemRepository extends JpaRepository<OrderMedicationItemEntity, OrderMedicationItemKey> {
  List<OrderMedicationItemEntity> findById_NumberOrder(int numberOrder);
}
