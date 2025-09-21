package app.infrastructure.persistence.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.OrderDiagnosticAidItemEntity;
import app.infrastructure.persistence.entities.OrderDiagnosticAidItemKey;
public interface OrderDiagnosticAidItemRepository extends JpaRepository<OrderDiagnosticAidItemEntity, OrderDiagnosticAidItemKey> {
  List<OrderDiagnosticAidItemEntity> findById_NumberOrder(int numberOrder);
}
