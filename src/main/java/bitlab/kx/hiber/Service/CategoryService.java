package bitlab.kx.hiber.Service;
//Anotation Service
import bitlab.kx.hiber.Category;
import bitlab.kx.hiber.Exceptions.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategory(Long id);

    Category addCategory(Category category);

    Category updateCategory(Category category)
            throws CategoryNotFoundException;

    void deleteCategory(Long id)
            throws CategoryNotFoundException;
}