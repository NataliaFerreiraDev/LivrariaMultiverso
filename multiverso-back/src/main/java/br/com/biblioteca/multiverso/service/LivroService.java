package br.com.biblioteca.multiverso.service;

import br.com.biblioteca.multiverso.domain.LivroEntity;
import br.com.biblioteca.multiverso.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Optional<LivroEntity> buscarPorId(@PathVariable Integer id){
        Optional<LivroEntity> livro = repository.findById(id);
        return livro;
    }

    public List<LivroEntity> buscarPorColecao(@PathVariable String colecao){
        List<LivroEntity> livroColecao = repository.findByColecao(colecao);
        return livroColecao;
    }

    public List<LivroEntity> listaPaginada(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable paginacao = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());

        Page<LivroEntity> listaPaginada = repository.findAll(paginacao);

        if(listaPaginada.hasContent()){
            return listaPaginada.getContent();
        }else {
            return new ArrayList<LivroEntity>();
        }

    }

    @Transactional
    public LivroEntity salvarLivro(LivroEntity livroEntity){
        return repository.save(livroEntity);
    }


}
