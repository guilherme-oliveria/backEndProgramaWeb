package br.edu.unievangelica.domain.product;

import br.edu.unievangelica.core.exception.CustomNotFoundException;
import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends AbstractService<Produto> {

    @Autowired
    public ProductRepository produtoRepository;

    public List<Produto> listarPorOrdemAlfabetica(){
        return produtoRepository.findAllByOrderByNomeAsc();
    }

    public List<Produto> listarPromocoes(){
        return  produtoRepository.findProdutoByAtivarPromocaoTrue();
    }

    public boolean delete(long id) {
        produtoRepository.delete(id);
        return true;
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return super.findAll();
    }

    public Produto update(Long id, Produto produto) {
        Produto produtoDB = Optional.ofNullable(produtoRepository.findOne(id))
                .orElseThrow(() -> new CustomNotFoundException("Produto não encontrada"));
        produto.setId(produtoDB.getId());
        return this.save(produto);
    }
}
