package bitlab.kx.hiber.Controllers;

import bitlab.kx.hiber.Item;
import bitlab.kx.hiber.Service.CountryComponent;
import bitlab.kx.hiber.Service.ItemComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller
    @RequiredArgsConstructor
    @RequestMapping("/items")
    public class ItemController {

        private final ItemComponent itemComponent;
        private final CountryComponent countryComponent;


        // ALL ITEMS

        @GetMapping
        public String index(Model model) {

            model.addAttribute(
                    "items",
                    itemComponent.getAll()
            );

            return "items";
        }


        // ADD PAGE

        @GetMapping("/add")
        public String addPage(Model model) {

            model.addAttribute(
                    "countries",
                    countryComponent.getAll()
            );

            return "items";
        }


        // ADD

        @PostMapping("/add")
        public String add(
                @RequestParam("name") String name,
                @RequestParam("price") int price,
                @RequestParam("country") Long countryId
        ) {

            itemComponent.add(
                    name,
                    price,
                    countryId
            );

            return "redirect:/items";
        }


        // DETAIL

        @GetMapping("/{id}")
        public String detail(
                @PathVariable Long id,
                Model model
        ) {

            Item item = itemComponent.getById(id);

            if (item == null) {
                return "redirect:/items";
            }

            model.addAttribute(
                    "item",
                    item
            );

            model.addAttribute(
                    "countries",
                    countryComponent.getAll()
            );

            return "items";
        }


        // UPDATE

        @PostMapping("/update")
        public String update(
                @RequestParam("id") Long id,
                @RequestParam("name") String name,
                @RequestParam("price") int price,
                @RequestParam("country") Long countryId
        ) {

            itemComponent.update(
                    id,
                    name,
                    price,
                    countryId
            );

            return "redirect:/items/" + id;
        }


        // DELETE

        @PostMapping("/delete")
        public String delete(
                @RequestParam("id") Long id
        ) {

            itemComponent.delete(id);

            return "redirect:/items";
        }
    }
