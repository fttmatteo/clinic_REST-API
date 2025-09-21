package app.infrastructure.persistence.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.infrastructure.persistence.entities.OrderProcedureItemEntity;
import app.infrastructure.persistence.entities.OrderProcedureItemKey;
public interface OrderProcedureItemRepository extends JpaRepository<OrderProcedureItemEntity, OrderProcedureItemKey> {
  List<OrderProcedureItemEntity> findById_NumberOrder(int numberOrder);
}
