package alejandro.course.projects.microservicesproject.mappers;

import java.util.List;
import java.util.stream.Collectors;

import alejandro.course.projects.microservicesproject.controllers.dto.InsuranceDto;
import alejandro.course.projects.microservicesproject.objects.Insurance;
import org.springframework.stereotype.Component;

@Component
public class InsuranceMapper {

    public Insurance dtoToObject(InsuranceDto insuranceDto){
        Insurance insurance = new Insurance();

        insurance.setId(insuranceDto.getId());
        insurance.setVehicleId(insuranceDto.getVehicleId());
        insurance.setPremiumCoverage(insuranceDto.getPremiumCoverage());
        insurance.setCoverage(insuranceDto.getCoverage());

        return insurance;
    }

    public List<Insurance> dtoToObject(List<InsuranceDto> insuranceDtoList){
        return insuranceDtoList.stream()
                .map(this::dtoToObject)
                .collect(Collectors.toList());
    }

    public InsuranceDto objectToDto(Insurance insurance){
        if (insurance==null)
            return null;

        InsuranceDto insuranceDto = new InsuranceDto();

        insuranceDto.setId(insurance.getId());
        insuranceDto.setVehicleId(insurance.getVehicleId());
        insuranceDto.setPremiumCoverage(insurance.getPremiumCoverage());
        insuranceDto.setCoverage(insurance.getCoverage());

        return insuranceDto;
    }

    public List<InsuranceDto> objectToDto(List<Insurance> insuranceList){
        return insuranceList.stream()
                .map(this::objectToDto)
                .collect(Collectors.toList());
    }
}
