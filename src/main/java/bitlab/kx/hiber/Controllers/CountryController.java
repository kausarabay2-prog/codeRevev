package bitlab.kx.hiber.Controllers;

import bitlab.kx.hiber.Service.CountryComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryComponent countryComponent;


    // ALL COUNTRIES

    @GetMapping
    public String index(Model model) {

        model.addAttribute(
                "countries",
                countryComponent.getAll()
        );

        return "countries";
    }


    // DETAIL

    @GetMapping("/{id}")
    public String detail(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "country",
                countryComponent.getById(id)
        );

        return "country";
    }


    // ADD

    @PostMapping("/add")
    public String add(
            @RequestParam("name") String name,
            @RequestParam("code") String code
    ) {

        countryComponent.add(name, code);

        return "redirect:/country";
    }


    // UPDATE

    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("code") String code
    ) {
        countryComponent.update(
                id,name
        );
        return "redirect:/country";
    }

    //delate
    @PostMapping("delete")
    public String delete(
            @RequestParam("id") Long id
    ){
        countryComponent.delete(id);
        return "redirect:/country";
    }

}