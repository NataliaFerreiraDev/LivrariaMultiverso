package br.com.biblioteca.multiverso.controller;

import br.com.biblioteca.multiverso.domain.LivroEntity;
import br.com.biblioteca.multiverso.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;


    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<LivroEntity>> buscarPorId(@PathVariable Integer id){
        Optional<LivroEntity> livro = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @GetMapping("/colecao/{colecao}")
    public ResponseEntity<List<LivroEntity>> buscarPorColecao(@PathVariable String colecao) {
        List<LivroEntity> livros = service.buscarPorColecao(colecao);
        return ResponseEntity.status(HttpStatus.OK).body(livros);
    }

    @GetMapping("/livro-paginacao")
    public ResponseEntity<List<LivroEntity>> listaPaginada(@RequestParam (defaultValue = "0") Integer pageNumber,
                                                           @RequestParam (defaultValue = "5") Integer pageSize,
                                                           @RequestParam (defaultValue = "idLivros") String sortBy
                                                           ){
        List<LivroEntity> livros = service.listaPaginada(pageNumber, pageSize, sortBy);
        return new ResponseEntity<List<LivroEntity>>(livros, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LivroEntity> cadastrarLivro(@RequestBody LivroEntity livroEntity){
        LivroEntity livroSalvo = service.salvarLivro(livroEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

}
