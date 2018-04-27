package br.edu.unievangelica.domain.category;

import br.edu.unievangelica.core.exception.CustomNotFoundException;
import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService extends AbstractService<Category> {

    @Autowired
    public CategoryRepository categoryRepository;

    public boolean delete(long id) {
        categoryRepository.delete(id);
        return true;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }

    public Category update(Long id, Category category) {
        Category categoryDB = Optional.ofNullable(categoryRepository.findOne(id))
                .orElseThrow(() -> new CustomNotFoundException("Categoria não encontrada"));
        category.setId(categoryDB.getId());
        return this.save(category);
    }


}
