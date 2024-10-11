package practices.baitap0710.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practices.baitap0710.com.entity.Category;
import practices.baitap0710.com.services.CategoryServices;

import java.util.List;

@Controller()
@RequestMapping("/")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    @GetMapping("category")
    public String index() {
        return "category";
    }

    @GetMapping("category/save")
    public String showCategory() {
        return "category-save";
    }

    @PostMapping("category/save")
    public ModelAndView saveCategory(@RequestParam String name, @RequestParam String description) {
        ModelAndView mav = new ModelAndView();
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryServices.createCategory(category);
        mav.setViewName("redirect:/category");
        return mav;
    }

    @GetMapping("category/show")
    public String showCategory(Model model) {
        List<Category> categories = categoryServices.findAllCategory();
        model.addAttribute("categories", categories);
        return "category-show";
    }
    @GetMapping("category/delete")
    public String showDelete(){
        return "category-delete";
    }
    @PostMapping("category/delete")
    public String deleteCategory(@RequestParam String name,Model model){
        Category category = categoryServices.findNameCategory(name);
        if (category != null) {
            model.addAttribute("categories", category);
        }
        return "category-delete";
    }

    @PostMapping("category/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable int id) {
        categoryServices.deleteCategory((long) id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/category");
        return mav;
    }
}
