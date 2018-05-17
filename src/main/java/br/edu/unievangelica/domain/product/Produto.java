package br.edu.unievangelica.domain.product;

import br.edu.unievangelica.domain.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_id_seq")
    @SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq", allocationSize = 3)
    @Column(name = "id")
    private long id;

    @NotNull //validar campos NULL
    @NotEmpty //validar strings vazias
    @Size(max = 80) //pode adicionar max e min exem: (max = 50, min = 10)
    private String nome;

    @NotNull
    @NotEmpty
    @Size(max = 60)
    private String marca;

    @Size(max = 200)
    private String descricao;

    @NotNull
    private float preco;

    @ManyToOne
    private Category category;
}
