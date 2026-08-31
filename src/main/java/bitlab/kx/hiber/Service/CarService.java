package bitlab.kx.hiber.Service;
//Anotation Service
import bitlab.kx.hiber.Car;
import bitlab.kx.hiber.Category;
import bitlab.kx.hiber.Exceptions.CarNotFoundException;
import bitlab.kx.hiber.Exceptions.CategoryNotFoundException;
import bitlab.kx.hiber.Exceptions.CountryNotFoundException;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    Car getCar(Long id);

    Car addCar(Car car)
            throws CountryNotFoundException;

    Car updateCar(Car car)
            throws CarNotFoundException,
            CountryNotFoundException;

    void deleteCar(Long id)
            throws CarNotFoundException;

    void assignCategory(Long carId, Long categoryId)
            throws CarNotFoundException,
            CategoryNotFoundException;

    void unassignCategory(Long carId, Long categoryId)
            throws CarNotFoundException,
            CategoryNotFoundException;

    List<Category> getAvailableCategories(Long carId)
            throws CarNotFoundException;
}
