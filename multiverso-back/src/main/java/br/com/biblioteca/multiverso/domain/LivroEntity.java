package br.com.biblioteca.multiverso.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "TB_LIVROS")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivros;

    private String nomeLivro;

    private String nomeAutor;

    private String colecao;

    private Integer anoEdicao;

    private Integer edicao;

}
