package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.VitalSignsBuilder;
import app.application.usecase.NurseUseCase;
import app.domain.model.VitalSignsRecord;

/**
 * Cliente de consola para enfermeras.
 * Permite registrar los signos vitales de un paciente de forma interactiva.
 */
@Controller
public class NurseClient {

    private static final String MENU =
        "Ingrese una opción:\n" +
        "1. Registrar signos vitales\n" +
        "2. Salir";

    private static final Scanner reader = new Scanner(System.in);

    @Autowired
    private NurseUseCase nurseUseCase;
    @Autowired
    private VitalSignsBuilder vitalSignsBuilder;

    public void session() {
        boolean running = true;
        while (running) {
            running = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            switch (option) {
            case "1": {
                VitalSignsRecord record = readVitalSignsData();
                nurseUseCase.recordVitalSigns(record);
                return true;
            }
            case "2": {
                System.out.println("Hasta luego. Cerrando sesión.");
                return false;
            }
            default: {
                System.out.println("Opción inválida. Por favor intente de nuevo.");
                return true;
            }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private VitalSignsRecord readVitalSignsData() throws Exception {
        System.out.println("Ingrese el documento de la enfermera:");
        String nurseDocument = reader.nextLine();
        System.out.println("Ingrese el documento del paciente:");
        String patientDocument = reader.nextLine();
        System.out.println("Ingrese la presión arterial (formato systolic/diastolic, por ejemplo 120/80):");
        String bloodPressure = reader.nextLine();
        System.out.println("Ingrese la temperatura (en grados Celsius):");
        String temperature = reader.nextLine();
        System.out.println("Ingrese el pulso (latidos por minuto):");
        String pulse = reader.nextLine();
        System.out.println("Ingrese el nivel de oxígeno (porcentaje):");
        String oxygenLevel = reader.nextLine();
        return vitalSignsBuilder.build(
            nurseDocument,
            patientDocument,
            bloodPressure,
            temperature,
            pulse,
            oxygenLevel
        );
    }
}