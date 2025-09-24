package app.adapter.in.builder;

import app.domain.model.Medicine;

public class MedicineBuilder {
    private Long medicineId;
    private String medicineName;
    private Double price;

    public MedicineBuilder withMedicineId(Long v){ this.medicineId = v; return this; }
    public MedicineBuilder withMedicineName(String v){ this.medicineName = v; return this; }
    public MedicineBuilder withPrice(Double v){ this.price = v; return this; }

    public Medicine build(){
        Medicine x = new Medicine();
        x.setMedicineId(medicineId);
        x.setMedicineName(medicineName);
        x.setPrice(price);
        return x;
    }
}
