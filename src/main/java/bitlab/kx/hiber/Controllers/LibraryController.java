package bitlab.kx.hiber.Controllers;
//ManyToOne
//OneToMany
import bitlab.kx.hiber.Service.LibraryComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryComponent libraryComponent;

    // ALL LIBRARIES
    @GetMapping
    public String index(Model model) {
        model.addAttribute("libraries", libraryComponent.getAll());
        return "libraries";
    }

    // GET DETAILS
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("library", libraryComponent.getById(id));
        return "library";
    }

    // ADD
    @PostMapping("/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("address") String address) {
        libraryComponent.add(name, address);
        return "redirect:/libraries";
    }

    // UPDATE
    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("address") String address
    ) {
        libraryComponent.update(id, name, address);
        return "redirect:/libraries/" + id;
    }

    // DELETE
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        libraryComponent.delete(id);
        return "redirect:/libraries";
    }
}