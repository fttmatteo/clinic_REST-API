package app.adapter.in.builder;

import app.domain.model.OrderItem;
import app.domain.model.enums.OrderItemType;

public class OrderItemBuilder {
    private Long orderItemId;
    private Long orderReference;
    private OrderItemType type;
    private String name;
    private String dose;
    private String duration;
    private Integer quantity;
    private String frequency;
    private boolean specialistRequired;
    private String specialistType;
    private Double price;

    public OrderItemBuilder withOrderItemId(Long v){ this.orderItemId = v; return this; }
    public OrderItemBuilder withOrderReference(Long v){ this.orderReference = v; return this; }
    public OrderItemBuilder withType(OrderItemType v){ this.type = v; return this; }
    public OrderItemBuilder withName(String v){ this.name = v; return this; }
    public OrderItemBuilder withDose(String v){ this.dose = v; return this; }
    public OrderItemBuilder withDuration(String v){ this.duration = v; return this; }
    public OrderItemBuilder withQuantity(Integer v){ this.quantity = v; return this; }
    public OrderItemBuilder withFrequency(String v){ this.frequency = v; return this; }
    public OrderItemBuilder withSpecialistRequired(boolean v){ this.specialistRequired = v; return this; }
    public OrderItemBuilder withSpecialistType(String v){ this.specialistType = v; return this; }
    public OrderItemBuilder withPrice(Double v){ this.price = v; return this; }

    public OrderItem build(){
        OrderItem x = new OrderItem();
        x.setOrderItemId(orderItemId);
        x.setOrderReference(orderReference);
        x.setType(type);
        x.setName(name);
        x.setDose(dose);
        x.setDuration(duration);
        x.setQuantity(quantity);
        x.setFrequency(frequency);
        x.setSpecialistRequired(specialistRequired);
        x.setSpecialistType(specialistType);
        x.setPrice(price);
        return x;
    }
}
