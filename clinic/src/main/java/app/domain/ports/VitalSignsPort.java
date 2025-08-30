
package app.domain.ports;

import app.domain.model.VitalSigns;

public interface VitalSignsPort {
    void save(VitalSigns vitalSigns);
}
