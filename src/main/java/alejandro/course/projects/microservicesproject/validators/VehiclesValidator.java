package alejandro.course.projects.microservicesproject.validators;

import java.util.HashMap;
import java.util.List;

import alejandro.course.projects.microservicesproject.exceptions.VehicleNotFoundException;
import alejandro.course.projects.microservicesproject.objects.Insurance;
import alejandro.course.projects.microservicesproject.repositories.VehiclesRepository;
import org.springframework.stereotype.Component;

@Component
public class VehiclesValidator {

    VehiclesRepository repository;

    public VehiclesValidator(VehiclesRepository repository) {
        this.repository = repository;
    }

    public void validateThereIsVehicle(List<Insurance> insurances){
        HashMap<String, String> vehiclesNotFound = new HashMap<>();

        insurances.forEach(insurance -> {
            if (repository.getVehicle(insurance.getVehicleId())==null){
                vehiclesNotFound.put(insurance.getId(), insurance.getVehicleId());
            }
        });

        if (vehiclesNotFound.isEmpty())
            return;

        StringBuilder stringBuilder = new StringBuilder();


        vehiclesNotFound.forEach((insuranceId, vehicleId) -> {
            stringBuilder.append(String.format("There is not vehicle id=%s for the insurance id=%s", vehicleId, insuranceId));
            stringBuilder.append(System.getProperty("line.separator"));
        });

        throw new VehicleNotFoundException(stringBuilder.toString());
    }
}
