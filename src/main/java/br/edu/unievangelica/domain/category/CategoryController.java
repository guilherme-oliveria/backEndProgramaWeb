package br.edu.unievangelica.domain.category;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController extends ResponseAbstractController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return jsonResponse(categoryService.listarPorOrdemAlfabetica());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return jsonResponse(categoryService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Category category){
        return jsonResponse(categoryService.save(category));
    }

    @PutMapping
    public ResponseEntity<?> update(@Validated @RequestBody Category category){
        return jsonResponse(categoryService.save(category));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return jsonResponse(categoryService.delete(id));
    }
}
