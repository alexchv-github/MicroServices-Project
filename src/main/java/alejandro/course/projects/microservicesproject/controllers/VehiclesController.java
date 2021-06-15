package alejandro.course.projects.microservicesproject.controllers;

import java.util.List;

import alejandro.course.projects.microservicesproject.controllers.dto.VehicleDto;
import alejandro.course.projects.microservicesproject.mappers.VehicleMapper;
import alejandro.course.projects.microservicesproject.objects.Vehicle;
import alejandro.course.projects.microservicesproject.services.VehiclesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesController {

    VehicleMapper mapper;

    VehiclesService service;

    public VehiclesController(VehicleMapper mapper,
            VehiclesService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping(value = "/vehicles", consumes = "application/json")
    public ResponseEntity<HttpStatus> addVehicles(@RequestBody List<VehicleDto> vehicles){
        service.addVehicles(mapper.dtoToObject(vehicles));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/vehicles/{id}", produces = "application/json")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable String id){
        VehicleDto vehicleDto = mapper.objectToDto(service.getVehicle(id));

        if (vehicleDto==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(vehicleDto, HttpStatus.FOUND);
    }

    @PutMapping(value = "/vehicles", consumes = "application/json")
    public ResponseEntity<HttpStatus> updateVehicle(@RequestBody VehicleDto vehicle){
        Vehicle updatedVehicle = service.updateVehicle(mapper.dtoToObject(vehicle));

        if (updatedVehicle==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/vehicles/{id}")
    public ResponseEntity<HttpStatus> removeVehicle(@PathVariable String id){
        Vehicle vehicleRemoved = service.removeVehicle(id);

        if (vehicleRemoved==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
