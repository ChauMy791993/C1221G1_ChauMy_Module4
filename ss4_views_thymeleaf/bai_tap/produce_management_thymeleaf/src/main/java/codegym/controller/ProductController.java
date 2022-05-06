package codegym.controller;

import codegym.model.Product;
import codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/")
    public String getList(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("productList", iProductService.findAll());
        redirectAttributes.addFlashAttribute("message", "");
        return "list";
    }

    @GetMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 100));
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Save product successfully");
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteForm(Model model, int id) {
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String deleteProduct(Product product, RedirectAttributes redirectAttributes) {
        iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewForm(Model model, int id) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

    @GetMapping("/edit")
    public String editFrom(Model model, int id) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","update successfully");
        return "redirect:/";
    }

    @GetMapping ("/search")
    public String searchProduct (Model model,String name){
        model.addAttribute("productList",iProductService.findByName(name));
        return "list";
    }


}
