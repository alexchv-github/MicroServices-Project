package alejandro.course.projects.microservicesproject.services;

import java.util.List;

import alejandro.course.projects.microservicesproject.objects.Vehicle;
import alejandro.course.projects.microservicesproject.repositories.VehiclesRepository;
import org.springframework.stereotype.Service;


@Service
public class VehiclesService {

    VehiclesRepository repository;

    public VehiclesService(VehiclesRepository repository) {
        this.repository = repository;
    }

    public void addVehicles(List<Vehicle> vehicles){
        repository.addVehicles(vehicles);
    }

    public Vehicle getVehicle(String id){
        return repository.getVehicle(id);
    }

    public Vehicle updateVehicle(Vehicle vehicle){
        Vehicle oldVehicle = repository.updateVehicle(vehicle);

        if (oldVehicle==null)
            return null;

        return vehicle;
    }

    public Vehicle removeVehicle(String id){
        return repository.removeVehicle(id);
    }
}
