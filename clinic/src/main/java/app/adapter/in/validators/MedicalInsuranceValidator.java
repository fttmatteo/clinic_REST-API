package app.adapter.in.validators;

import java.sql.Date;
import app.application.exceptions.InputsException;
import org.springframework.stereotype.Component;

@Component
public class MedicalInsuranceValidator extends SimpleValidator {

    public String companyNameValidator(String value) throws Exception {
        return maxLength("compañía del seguro", value, 100);
    }

    public long numberPolicyValidator(String value) throws Exception {
        long n = longValidator("número de póliza", value);
        if (n <= 0) throw new InputsException("número de póliza debe ser positivo");
        return n;
    }

    public boolean statusPolicyValidator(String value) throws Exception {
        return booleanValidator("estado de póliza", value);
    }

    public Date endDatePolicyValidator(String value) throws Exception {
        return dateValidator("fin de vigencia de la póliza", value);
    }
}
