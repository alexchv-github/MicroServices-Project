package alejandro.course.projects.microservicesproject.repositories;

import java.util.HashMap;
import java.util.List;

import alejandro.course.projects.microservicesproject.objects.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehiclesRepository {

    static HashMap<String, Vehicle> vehiclesRepositoryStorage = new HashMap<>();

    public void addVehicles(List<Vehicle> vehicles){
        vehicles.forEach(vehicle -> vehiclesRepositoryStorage.put(vehicle.getId(), vehicle));
    }

    public Vehicle getVehicle(String id){
        return vehiclesRepositoryStorage.get(id);
    }

    public void updateVehicle(Vehicle vehicle){
        vehiclesRepositoryStorage.replace(vehicle.getId(), vehicle);
    }

    public Vehicle deleteVehicle(String id){
        return vehiclesRepositoryStorage.remove(id);
    }

}
