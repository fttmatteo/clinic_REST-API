package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.application.exceptions.BusinessException;
import app.domain.model.Employee;
import app.domain.ports.EmployeePort;

/**
 * Servicio de dominio responsable de crear empleados en la clínica. Aplica
 * reglas de negocio antes de delegar la persistencia al puerto de
 * infraestructura. Verifica que el documento y el nombre de usuario no se
 * encuentren registrados previamente.
 */
@Service
public class CreateEmployee {

    @Autowired
    private EmployeePort employeePort;

    public void create(Employee employee) throws Exception {
        if (employeePort.findByDocument(employee) != null) {
            throw new BusinessException("ya existe una persona registrada con esa cedula");
        }
        if (employeePort.findByUserName(employee) != null) {
            throw new BusinessException("ya existe una persona registrada con ese nombre de usuario");
        }
        employeePort.save(employee);
    }
}