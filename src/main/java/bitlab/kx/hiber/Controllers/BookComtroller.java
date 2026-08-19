package bitlab.kx.hiber.Controllers;

import bitlab.kx.hiber.Book;
import bitlab.kx.hiber.Service.BookComponent;
import bitlab.kx.hiber.Service.CountryComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookComtroller {
    private final BookComponent bookComponent;
    private final CountryComponent countryComponent;



    // ALL COUNTRIES

    @GetMapping
    public String index(Model model) {

        model.addAttribute(
                "books",
                bookComponent.getAll()
        );

        return "redirect:/books";
    }


    // DETAIL

    @GetMapping("/{id}")
    public String detail(
            @PathVariable Long id,
            Model model
    ) {
        Book book = bookComponent.getById(id);

        model.addAttribute(
                "books",
                bookComponent.getById(id)
        );

        return "books";
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
