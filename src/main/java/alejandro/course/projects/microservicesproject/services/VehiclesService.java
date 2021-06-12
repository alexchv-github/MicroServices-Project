package alejandro.course.projects.microservicesproject.services;

import java.util.List;

import alejandro.course.projects.microservicesproject.objects.Vehicle;
import alejandro.course.projects.microservicesproject.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehiclesService {

    @Autowired
    VehiclesRepository repository;

    public void addVehicles(List<Vehicle> vehicles){
        repository.addVehicles(vehicles);
    }

    public Vehicle getVehicle(String id){
        return repository.getVehicle(id);
    }

    public void updateVehicle(Vehicle vehicle){
        repository.updateVehicle(vehicle);
    }

    public void deleteVehicle(String id){
        repository.deleteVehicle(id);
    }
}
