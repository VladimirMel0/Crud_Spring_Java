package br.com.produto.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.produto.api.Modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{
    
    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);

    List<Pessoa> findByOrderByNomeDesc();
    //Asc-padrão
    //Desc-decrescente 

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);
    //ordernar por nome especifico
}
