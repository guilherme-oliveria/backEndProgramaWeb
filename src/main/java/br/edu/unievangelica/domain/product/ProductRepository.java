package br.edu.unievangelica.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByOrderByNomeAsc();
}
