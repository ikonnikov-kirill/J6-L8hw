package J6L8hw.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import J6L8hw.model.Product;
import J6L8hw.service.ProductService;

import java.util.Date;

@Controller
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public String showProducts(Model model) {
        return "redirect:/products/page/1";
    }

    @GetMapping("/page/{page}")
    public String showProducts(@PathVariable("page") int pageNumber, Model model) {
        Page products = productService.findAll(--pageNumber);
        model.addAttribute("products", products.getContent());
        model.addAttribute("pageNumber", products.getNumber()+1);
        model.addAttribute("totalPages", products.getTotalPages());
        return "products/showAll";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "products/show";
    }

    @GetMapping("/new")
    public String addProduct(@ModelAttribute("product") Product product) {
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product) {
        product.getPrice().setDate(new Date());
        productService.save(product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
