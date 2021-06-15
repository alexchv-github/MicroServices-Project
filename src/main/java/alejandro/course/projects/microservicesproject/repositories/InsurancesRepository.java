package alejandro.course.projects.microservicesproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import alejandro.course.projects.microservicesproject.objects.Insurance;
import org.springframework.stereotype.Repository;

@Repository
public class InsurancesRepository {

    static HashMap<String, Insurance> insurancesRepositoryStorage = new HashMap<>();

    public void addInsurances(List<Insurance> vehicles){
        vehicles.forEach(vehicle -> insurancesRepositoryStorage.put(vehicle.getId(), vehicle));
    }

    public List<Insurance> getInsurancesByVehicleId(String vehicleId){
        return (new ArrayList<>(insurancesRepositoryStorage.values())).stream()
                .filter(insurance -> insurance.getVehicleId().equalsIgnoreCase(vehicleId))
                .collect(Collectors.toList());
    }

    public Insurance getInsurance(String id){
        return insurancesRepositoryStorage.get(id);
    }

    public Insurance updateInsurance(Insurance insurance){
        return insurancesRepositoryStorage.replace(insurance.getId(), insurance);
    }

    public Insurance removeInsurance(String id){
        return insurancesRepositoryStorage.remove(id);
    }

}
