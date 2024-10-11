package practices.baitap0710.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practices.baitap0710.com.entity.Category;
import practices.baitap0710.com.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id,Category categoryDetail) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        category.setName(categoryDetail.getName());
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    public Category findNameCategory(String name){
        return categoryRepository.findByName(name);
    }

}
