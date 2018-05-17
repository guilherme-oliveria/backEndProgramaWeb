package br.edu.unievangelica.domain.provincia;

import br.edu.unievangelica.domain.pais.Pais;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provincia_id_seq")
    @SequenceGenerator(name = "provincia_id_seq", sequenceName = "provincia_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String nome;

    @Size(min = 2, max = 5)
    private String sigla;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;
}
