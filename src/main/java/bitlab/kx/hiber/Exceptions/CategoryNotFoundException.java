package bitlab.kx.hiber.Exceptions;

public class CategoryNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Category not found!";
    }
}