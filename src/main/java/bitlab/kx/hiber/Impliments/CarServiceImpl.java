package bitlab.kx.hiber.Impliments;
import bitlab.kx.hiber.Car;
import bitlab.kx.hiber.Category;
import bitlab.kx.hiber.Country;
import bitlab.kx.hiber.Exceptions.CarNotFoundException;
import bitlab.kx.hiber.Exceptions.CategoryNotFoundException;
import bitlab.kx.hiber.Exceptions.CountryNotFoundException;
import bitlab.kx.hiber.Service.CarService;
import bitlab.kx.hiber.repository.CarRepository;
import bitlab.kx.hiber.repository.CategoryRepository;
import bitlab.kx.hiber.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//Anotation Service
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CountryRepository countryRepository;
    private final CategoryRepository categoryRepository;

    private Country getCountry(Long id) {
        return countryRepository
                .findById(id)
                .orElse(null);
    }

    private Category getCategory(Long id) {
        return categoryRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(Long id) {
        return carRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Car addCar(Car car)
            throws CountryNotFoundException {

        Country country =
                getCountry(car.getCountry().getId());

        if (Objects.isNull(country)) {
            throw new CountryNotFoundException();
        }

        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car)
            throws CarNotFoundException,
            CountryNotFoundException {

        Car checkCar = getCar(car.getId());

        if (Objects.isNull(checkCar)) {
            throw new CarNotFoundException();
        }

        Country country =
                getCountry(car.getCountry().getId());

        if (Objects.isNull(country)) {
            throw new CountryNotFoundException();
        }

        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id)
            throws CarNotFoundException {

        Car car = getCar(id);

        if (Objects.isNull(car)) {
            throw new CarNotFoundException();
        }

        carRepository.deleteById(id);
    }

    @Override
    public void assignCategory(
            Long carId,
            Long categoryId)
            throws CarNotFoundException,
            CategoryNotFoundException {

        Car car = getCar(carId);

        if (Objects.isNull(car)) {
            throw new CarNotFoundException();
        }

        Category category = getCategory(categoryId);

        if (Objects.isNull(category)) {
            throw new CategoryNotFoundException();
        }

        List<Category> categories = car.getCategories();

        if (Objects.isNull(categories)) {
            categories = new ArrayList<>();
        }

        categories.add(category);

        car.setCategories(categories);

        carRepository.save(car);
    }

    @Override
    public void unassignCategory(
            Long carId,
            Long categoryId)
            throws CarNotFoundException,
            CategoryNotFoundException {

        Car car = getCar(carId);

        if (Objects.isNull(car)) {
            throw new CarNotFoundException();
        }

        Category category = getCategory(categoryId);

        if (Objects.isNull(category)) {
            throw new CategoryNotFoundException();
        }

        List<Category> categories = car.getCategories();

        if (Objects.isNull(categories)) {
            categories = new ArrayList<>();
        }

        categories.remove(category);

        car.setCategories(categories);

        carRepository.save(car);
    }

    @Override
    public List<Category> getAvailableCategories(Long carId)
            throws CarNotFoundException {

        Car car = getCar(carId);

        if (Objects.isNull(car)) {
            throw new CarNotFoundException();
        }

        List<Category> categories =
                categoryRepository.findAll();

        if (car.getCategories() != null) {
            categories.removeAll(car.getCategories());
        }

        return categories;
    }
}