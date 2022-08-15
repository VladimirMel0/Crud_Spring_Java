package br.com.produto.api.Controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.api.Modelo.Pessoa;
import br.com.produto.api.repositorio.Repositorio;

@RestController
public class Controle {
    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }



    @GetMapping("")
    public String mensagem(){
        return "Hello" ;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste" ;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;

    }
}

