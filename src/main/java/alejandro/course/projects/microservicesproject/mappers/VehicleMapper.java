package alejandro.course.projects.microservicesproject.mappers;

import java.util.List;
import java.util.stream.Collectors;

import alejandro.course.projects.microservicesproject.controllers.dto.VehicleDto;
import alejandro.course.projects.microservicesproject.objects.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle dtoToObject(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDto.getId());
        vehicle.setPlate(vehicleDto.getPlate());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setRegistrationDate(vehicleDto.getRegistrationDate());
        vehicle.setColour(vehicleDto.getColour());

        return vehicle;
    }

    public List<Vehicle> dtoToObject(List<VehicleDto> vehicleDtoList){
        return vehicleDtoList.stream()
                .map(this::dtoToObject)
                .collect(Collectors.toList());
    }

    public VehicleDto objectToDto(Vehicle vehicle){
        if (vehicle==null)
            return null;

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setPlate(vehicle.getPlate());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setRegistrationDate(vehicle.getRegistrationDate());
        vehicleDto.setColour(vehicle.getColour());

        return vehicleDto;
    }
}
