package bitlab.kx.hiber.Controllers;


import bitlab.kx.hiber.Product;
import bitlab.kx.hiber.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

@RequestMapping("/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;

    }


    @GetMapping
    public String getProducts(Model model) {

        List<Product> products =
                productService.getAllProducts();

        model.addAttribute("products", products);

        return "products";

    }

    // CREATE PAGE

    @GetMapping("/add")

    public String addProductPage(Model model) {

        model.addAttribute(

                "product",

                new Product()

        );

        return "add-product";

    }

    // CREATE

    @PostMapping("/add")

    public String addProduct(

            @ModelAttribute Product product

    ) {

        productService.addProduct(product);

        return "redirect:/products";

    }

    // READ ONE

    @GetMapping("/{id}")

    public String productDetails(

            @PathVariable Long id,

            Model model

    ) {

        Product product =

                productService.getProductById(id);

        if (product == null) {

            return "redirect:/products";

        }

        model.addAttribute(

                "product",

                product

        );

        return "product-details";

    }

    // UPDATE PAGE

    @GetMapping("/{id}/edit")

    public String editProductPage(

            @PathVariable Long id,

            Model model

    ) {

        Product product =

                productService.getProductById(id);

        if (product == null) {

            return "redirect:/products";

        }

        model.addAttribute(

                "product",

                product

        );

        return "edit-product";
    }
    @PostMapping("/{id}/edit")

    public String updateProduct(

            @PathVariable Long id,

            @ModelAttribute Product product

    ) {product.setId(id);
        productService.updateProduct(product);

        return "redirect:/products";

    }

    // DELETE

    @PostMapping("/{id}/delete")

    public String deleteProduct(

            @PathVariable Long id

    ) {

        productService.delateProduct(id);

        return "redirect:/products";

    }

    // SEARCH

    @GetMapping("/search")

    public String search(

            @RequestParam String name,

            Model model

    ) {

        List<Product> products =

                productService.search(name);

        model.addAttribute(

                "products",

                products

        );

        return "products";

    }

    // FILTER

    @GetMapping("/filter")

    public String filter(

            @RequestParam double min,

            @RequestParam double max,

            Model model

    ) {

        List<Product> products =

                productService.filterByPrice(

                        min,

                        max

                );

        model.addAttribute(

                "products",

                products

        );

        return "products";

    }

}