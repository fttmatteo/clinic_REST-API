package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.OrderDiagnosticAidItemValidator;
import app.domain.model.OrderDiagnosticAidItem;

@Component
public class OrderDiagnosticAidItemBuilder {

    @Autowired private OrderDiagnosticAidItemValidator validator;

    public OrderDiagnosticAidItem build(
        String numberOrder,
        String item,
        String diagnosticAid,
        String quantity,
        String specialistRequired,
        String specialistId,
        String price
    ) throws Exception {

        OrderDiagnosticAidItem orderDiagnosticAidItem = new OrderDiagnosticAidItem();
        orderDiagnosticAidItem.setNumberOrder(validator.numberOrderValidator(numberOrder));
        orderDiagnosticAidItem.setItem(validator.itemValidator(item));
        orderDiagnosticAidItem.setDiagnosticAid(validator.idDiagnosticAidValidator(diagnosticAid));
        orderDiagnosticAidItem.setQuantity(validator.quantityValidator(quantity));
        orderDiagnosticAidItem.setSpecialistRequired(validator.specialistRequiredValidator(specialistRequired));
        orderDiagnosticAidItem.setSpecialistId(validator.specialistTypeIdValidator(specialistId));
        orderDiagnosticAidItem.setPrice(validator.costValidator(price));
        return orderDiagnosticAidItem;
    }
}
