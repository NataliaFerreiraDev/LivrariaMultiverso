package br.com.biblioteca.multiverso.repository;

import br.com.biblioteca.multiverso.domain.LivroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivroRepository extends PagingAndSortingRepository<LivroEntity, Integer> {

    List<LivroEntity> findByColecao(String colecao);

    Page<LivroEntity> findByNomeLivro(String nomeLivro, Pageable paginacao);

}
