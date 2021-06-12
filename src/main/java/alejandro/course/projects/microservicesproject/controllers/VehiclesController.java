package alejandro.course.projects.microservicesproject.controllers;

import java.util.List;
import java.util.stream.Collectors;

import alejandro.course.projects.microservicesproject.controllers.dto.VehicleDto;
import alejandro.course.projects.microservicesproject.mappers.VehicleMapper;
import alejandro.course.projects.microservicesproject.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesController {

    @Autowired
    VehicleMapper mapper;

    @Autowired
    VehiclesService service;

    @PostMapping(value = "/vehicles", consumes = "application/json")
    public void addVehicles(@RequestBody List<VehicleDto> vehicles){
        service.addVehicles(
                vehicles.stream()
                        .map(vehicleDto -> mapper.dtoToObject(vehicleDto))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "/vehicles/{id}", produces = "application/json")
    public VehicleDto getVehicle(@PathVariable String id){
        return mapper.objectToDto(service.getVehicle(id));
    }

    @PutMapping(value = "/vehicles", consumes = "application/json")
    public void updateVehicle(@RequestBody VehicleDto vehicle){
        service.updateVehicle(mapper.dtoToObject(vehicle));
    }

    @DeleteMapping(value = "/vehicles/{id}")
    public void deleteVehicle(@PathVariable String id){
        service.deleteVehicle(id);
    }

}
