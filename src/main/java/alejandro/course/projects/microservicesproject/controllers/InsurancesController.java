package alejandro.course.projects.microservicesproject.controllers;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import alejandro.course.projects.microservicesproject.controllers.dto.InsuranceDto;
import alejandro.course.projects.microservicesproject.mappers.InsuranceMapper;
import alejandro.course.projects.microservicesproject.objects.Insurance;
import alejandro.course.projects.microservicesproject.services.InsurancesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class InsurancesController {

    InsuranceMapper mapper;

    InsurancesService service;

    public InsurancesController(InsuranceMapper mapper,
            InsurancesService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping(value = "/insurances/vehicles/{vehicleId}")
    public ResponseEntity<List<InsuranceDto>> getInsurancesVehicle(@PathVariable @NotBlank String vehicleId){
        List<InsuranceDto> insuranceDtoList = mapper.objectToDto(service.getInsurancesByVehicleId(vehicleId));

        if (CollectionUtils.isEmpty(insuranceDtoList))
            return new ResponseEntity<>(insuranceDtoList, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(insuranceDtoList, HttpStatus.FOUND);
    }

    @GetMapping(value = "/insurances/{insuranceId}")
    public ResponseEntity<InsuranceDto> getInsurance(@PathVariable @NotBlank String insuranceId){
        InsuranceDto insuranceDto = mapper.objectToDto(service.getInsurance(insuranceId));

        if (insuranceDto==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(insuranceDto, HttpStatus.FOUND);
    }

    @PostMapping(value = "/insurances")
    public ResponseEntity<HttpStatus> addInsurances(@RequestBody @Valid List<InsuranceDto> insurances){
        service.addInsurances(mapper.dtoToObject(insurances));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/insurances")
    public ResponseEntity<HttpStatus> updateInsurance(@RequestBody @Valid InsuranceDto insuranceDto){
        Insurance insurance = service.updateInsurance(mapper.dtoToObject(insuranceDto));

        if (insurance==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/insurances/{insuranceId}")
    public ResponseEntity<HttpStatus> deleteInsurance(@PathVariable @NotBlank String insuranceId){
        Insurance insuranceRemoved = service.removeInsurance(insuranceId);

        if (insuranceRemoved==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
