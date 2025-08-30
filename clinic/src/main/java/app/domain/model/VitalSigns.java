package app.domain.model;

public class VitalSigns {
    private String patientId;
    private double pressure;
    private double temperature;
    private int pulse;
    private double oxygen;

    public VitalSigns(String patientId, double pressure, double temperature, int pulse, double oxygen) {
        this.patientId = patientId;
        this.pressure = pressure;
        this.temperature = temperature;
        this.pulse = pulse;
        this.oxygen = oxygen;
    }

    public String getPatientId() { return patientId; }
    public double getPressure() { return pressure; }
    public double getTemperature() { return temperature; }
    public int getPulse() { return pulse; }
    public double getOxygen() { return oxygen; }
}
