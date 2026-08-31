package bitlab.kx.hiber.Exceptions;

public class CountryNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Country not found!";
    }
}
