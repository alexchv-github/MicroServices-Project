package alejandro.course.projects.microservicesproject.exceptions;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
