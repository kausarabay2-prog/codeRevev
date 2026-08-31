package bitlab.kx.hiber.Controllers;

import bitlab.kx.hiber.Car;
import bitlab.kx.hiber.Category;
import bitlab.kx.hiber.Exceptions.CarNotFoundException;
import bitlab.kx.hiber.Exceptions.CategoryNotFoundException;
import bitlab.kx.hiber.Exceptions.CountryNotFoundException;
import bitlab.kx.hiber.Service.CarService;
import bitlab.kx.hiber.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CountryService countryService;

    @GetMapping("/")
    public String cars(Model model) {

        model.addAttribute(
                "cars",
                carService.getCars()
        );

        return "cars";
    }

    @GetMapping("/add-car")
    public String addCarPage(Model model) {

        model.addAttribute(
                "countries",
                countryService.getCountries()
        );

        return "add-car";
    }

    @PostMapping("/add-car")
    public String addCar(Car car) {

        try {

            carService.addCar(car);

            return "redirect:/";

        } catch (CountryNotFoundException e) {

            return "redirect:/add-car";
        }
    }

    @GetMapping("/car")
    public String carDetails(
            Model model,
            @RequestParam Long id) {

        Car car = carService.getCar(id);

        if (Objects.isNull(car)) {
            return "redirect:/404";
        }

        model.addAttribute("car", car);

        try {

            List<Category> categories =
                    carService.getAvailableCategories(id);

            model.addAttribute(
                    "categories",
                    categories
            );

        } catch (CarNotFoundException e) {

            return "redirect:/404";
        }

        return "car-details";
    }

    @PostMapping("/delete-car")
    public String deleteCar(
            @RequestParam Long id) {

        try {

            carService.deleteCar(id);

            return "redirect:/";

        } catch (CarNotFoundException e) {

            return "redirect:/404";
        }
    }

    @PostMapping("/assign-category")
    public String assignCategory(
            @RequestParam Long carId,
            @RequestParam Long categoryId) {

        try {

            carService.assignCategory(
                    carId,
                    categoryId
            );

        } catch (CarNotFoundException |
                 CategoryNotFoundException e) {

            return "redirect:/404";
        }

        return "redirect:/car?id=" + carId;
    }

    @PostMapping("/unassign-category")
    public String unassignCategory(
            @RequestParam Long carId,
            @RequestParam Long categoryId) {

        try {

            carService.unassignCategory(
                    carId,
                    categoryId
            );

        } catch (CarNotFoundException |
                 CategoryNotFoundException e) {

            return "redirect:/404";
        }

        return "redirect:/car?id=" + carId;
    }

    @GetMapping("/404")
    public String error() {
        return "404";
    }
}