package com.trabalho.teste.controllers;

import com.trabalho.teste.models.Pessoa;
import com.trabalho.teste.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public List<Pessoa> findAll() {
        List<Pessoa> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id) {
        Pessoa result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    public Pessoa insert(@RequestBody Pessoa pessoa) {
        Pessoa result = repository.save(pessoa);
        return result;
    }
}
