package br.edu.unievangelica.domain.product;

import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractService<Produto> {

    @Autowired
    public ProductRepository productRepository;

    public List<Produto> listarPorOrdemAlfabetica(){
        return productRepository.findAllByOrderByNomeAsc();
    }
}
