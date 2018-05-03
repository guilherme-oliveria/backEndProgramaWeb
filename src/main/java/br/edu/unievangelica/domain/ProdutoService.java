package br.edu.unievangelica.domain;

import br.edu.unievangelica.core.exception.CustomNotFoundException;
import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService extends AbstractService<Produto>{

    @Autowired
    public ProdutoRepository produtoRepository;

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
                .orElseThrow(() -> new CustomNotFoundException("Categoria não encontrada"));

        return this.save(produto);
    }


}
