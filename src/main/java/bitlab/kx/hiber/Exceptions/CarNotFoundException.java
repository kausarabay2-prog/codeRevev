package bitlab.kx.hiber.Exceptions;

public class CarNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Car not found!";
    }
}
