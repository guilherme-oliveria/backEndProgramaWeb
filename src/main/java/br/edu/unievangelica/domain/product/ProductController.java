package br.edu.unievangelica.domain.product;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProductController extends ResponseAbstractController{

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return jsonResponse(productService.listarPorOrdemAlfabetica());
    }

    @GetMapping(value = "/promocao")
    public ResponseEntity<List<Produto>> allProdutos() {
        return (ResponseEntity<List<Produto>>) jsonResponse(productService.listarPromocoes());
    }

    @GetMapping(value = "/semPromocao")
    public ResponseEntity<List<Produto>> semPromoProdutos() {
        return (ResponseEntity<List<Produto>>) jsonResponse(productService.listarProdutosSemPromo());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return jsonResponse(productService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Produto produto){
        return jsonResponse(productService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Produto produto) {
        return new ResponseEntity<>(productService.update(id, produto), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return jsonResponse(productService.delete(id));
    }
}