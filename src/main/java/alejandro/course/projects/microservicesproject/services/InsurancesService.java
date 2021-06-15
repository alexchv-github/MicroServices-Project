package alejandro.course.projects.microservicesproject.services;

import java.util.List;

import alejandro.course.projects.microservicesproject.objects.Insurance;
import alejandro.course.projects.microservicesproject.repositories.InsurancesRepository;
import alejandro.course.projects.microservicesproject.validators.VehiclesValidator;
import org.springframework.stereotype.Service;


@Service
public class InsurancesService {

    InsurancesRepository repository;
    VehiclesValidator vehiclesValidator;

    public InsurancesService(InsurancesRepository repository, VehiclesValidator vehiclesValidator) {
        this.repository = repository;
        this.vehiclesValidator = vehiclesValidator;
    }

    public void addInsurances(List<Insurance> insurances){
        vehiclesValidator.validateThereIsVehicle(insurances);
        repository.addInsurances(insurances);
    }

    public List<Insurance> getInsurancesByVehicleId(String vehicleId){
        return repository.getInsurancesByVehicleId(vehicleId);
    }

    public Insurance getInsurance(String id){
        return repository.getInsurance(id);
    }

    public Insurance updateInsurance(Insurance insurance){
        Insurance oldInsurance = repository.updateInsurance(insurance);

        if (oldInsurance==null)
            return null;

        return insurance;
    }

    public Insurance removeInsurance(String id){
        return repository.removeInsurance(id);
    }
}
