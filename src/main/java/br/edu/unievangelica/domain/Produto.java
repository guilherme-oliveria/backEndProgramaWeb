package br.edu.unievangelica.domain;

import br.edu.unievangelica.domain.category.Category;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="produto")
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id_seq")
    @SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq", allocationSize = 1)
    @Column(name = "id")
    @Getter
    private long id;

    @NotEmpty
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;


    @NotNull
    @Size(max = 50)
    @Column(name = "preco")
    private Double preco;

    @NotEmpty
    @Size(max = 50)
    @Column(name = "marca")
    private String marca;

    @NotEmpty
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "produto")// aplicacao pequena melhor EAGER
    private List<Category> categorias;


    public Produto() {
    }
}
