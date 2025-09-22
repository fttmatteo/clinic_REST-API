package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.OrderProcedureItemValidator;
import app.domain.model.OrderProcedureItem;

@Component
public class OrderProcedureItemBuilder {

    @Autowired private OrderProcedureItemValidator validator;

    public OrderProcedureItem build(
        String numberOrder,
        String item,
        String procedureId,
        String quantity,
        String frequency,
        String specialistRequired,
        String specialistId,
        String price
    ) throws Exception {

        OrderProcedureItem orderProcedureItem = new OrderProcedureItem();
        orderProcedureItem.setNumberOrder(validator.numberOrderValidator(numberOrder));
        orderProcedureItem.setItem(validator.itemValidator(item));
        orderProcedureItem.setProcedureId(validator.idProcedureValidator(procedureId));
        orderProcedureItem.setQuantity(validator.quantityValidator(quantity));
        orderProcedureItem.setFrequency(validator.frequencyValidator(frequency));
        orderProcedureItem.setSpecialistRequired(validator.specialistRequiredValidator(specialistRequired));
        orderProcedureItem.setSpecialistId(validator.specialistTypeIdValidator(specialistId));
        orderProcedureItem.setPrice(validator.costValidator(price));
        return orderProcedureItem;
    }
}
