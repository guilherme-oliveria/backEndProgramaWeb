package br.edu.unievangelica.domain.category;

import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends AbstractService<Category> {

    @Autowired
    public CategoryRepository categoryRepository;

    public List<Category> listarPorOrdemAlfabetica(){
        return categoryRepository.findAllByOrderByNomeAsc();
    }
}
