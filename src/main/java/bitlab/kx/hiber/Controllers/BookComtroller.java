package bitlab.kx.hiber.Controllers;
//ManyToOne
//OneToMany
import bitlab.kx.hiber.Book;
import bitlab.kx.hiber.Service.BookComponent;
import bitlab.kx.hiber.Service.CountryComponent;
import bitlab.kx.hiber.Service.LibraryComponent;
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
    private final LibraryComponent libraryComponent;

    // ALL BOOKS
    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookComponent.getAll());
        return "books";
    }

    // ADD PAGE
    @GetMapping("/add")
    public String addPage(Model model){
        model.addAttribute("libraries", libraryComponent.getAll());
        return "book";
    }

    // ADD
    @PostMapping("/add")
    public String add(
            @RequestParam("title") String title,
            @RequestParam("author") String author,   // ЖӨНДЕЛДІ
            @RequestParam("price") int price,
            @RequestParam("library") Long libraryId
    ){
        bookComponent.add(title, author, price, libraryId);
        return "redirect:/books";
    }

    // DETAIL
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model){
        Book book = bookComponent.getById(id);
        if (book == null){
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("libraries", libraryComponent.getAll());
        return "book";
    }

    // UPDATE
    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("author") String author,   // ЖӨНДЕЛДІ
            @RequestParam("price") int price,
            @RequestParam("library") Long libraryId
    ){
        bookComponent.update(id, title, author, price, libraryId);
        return "redirect:/books/" + id;
    }

    // DELETE
    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        bookComponent.delete(id);
        return "redirect:/books";
    }
}