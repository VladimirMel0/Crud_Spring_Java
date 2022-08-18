package br.com.produto.api.Controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.api.Modelo.Pessoa;
import br.com.produto.api.repositorio.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    // colocando registro no banco de dados
    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    // ver todos os registros 
    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    // selecionar registro por codigo
    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }
    
    // atualização de registro
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }
    
    // delete de registro
    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);

    }
    // contador de registro
    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }   
    
    // ordernar por nome 
    @GetMapping("/api/ordernarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNomeDesc();
    }

    //filtrar por nome e ordernar por idade 
    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordernarNomes2(){
        return acao.findByNomeOrderByIdade("lais");
    }




    // hello
    @GetMapping("")
    public String mensagem(){
        return "Hello" ;
    }
    // teste
    @GetMapping("/teste")
    public String teste(){
        return "Teste" ;
    }
    // teste post
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;

    }
}

