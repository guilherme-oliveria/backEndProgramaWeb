package br.edu.unievangelica.domain.category;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController extends ResponseAbstractController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return jsonResponse(categoryService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable long id) {
        return jsonResponse(categoryService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return jsonResponse(categoryService.delete(id));
    }

}