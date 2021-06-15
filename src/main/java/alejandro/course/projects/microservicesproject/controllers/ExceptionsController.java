package alejandro.course.projects.microservicesproject.controllers;

import java.util.Date;

import alejandro.course.projects.microservicesproject.exceptions.GeneralExceptionObject;
import alejandro.course.projects.microservicesproject.exceptions.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class ExceptionsController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralExceptionObject> exceptionsHandler(Exception ex, WebRequest request){
        logger.error(ex.getMessage(), ex);

        GeneralExceptionObject generalExceptionObject = new GeneralExceptionObject(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE));

        return new ResponseEntity<>(generalExceptionObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<GeneralExceptionObject> vehicleNotFoundExceptionHandler(Exception ex, WebRequest request){
        logger.error(ex.getMessage(), ex);

        GeneralExceptionObject generalExceptionObject = new GeneralExceptionObject(new Date(), ex.getMessage(), request.getDescription(Boolean.FALSE));

        return new ResponseEntity<>(generalExceptionObject, HttpStatus.NOT_FOUND);
    }
}
