package bitlab.kx.hiber.Impliments;
//Anotation Service
import bitlab.kx.hiber.Category;
import bitlab.kx.hiber.Exceptions.CategoryNotFoundException;
import bitlab.kx.hiber.Service.CategoryService;
import bitlab.kx.hiber.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl
        implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category)
            throws CategoryNotFoundException {

        Category checkCategory =
                getCategory(category.getId());

        if (Objects.isNull(checkCategory)) {
            throw new CategoryNotFoundException();
        }

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id)
            throws CategoryNotFoundException {

        Category checkCategory = getCategory(id);

        if (Objects.isNull(checkCategory)) {
            throw new CategoryNotFoundException();
        }

        categoryRepository.deleteById(id);
    }
}