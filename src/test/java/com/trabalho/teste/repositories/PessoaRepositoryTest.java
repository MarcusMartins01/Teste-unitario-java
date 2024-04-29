package com.trabalho.teste.repositories;

import com.trabalho.teste.dto.PessoaDto;
import com.trabalho.teste.models.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("teste")
class PessoaRepositoryTest {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get pessoa successfully from database")
    void findByCpfSuccess() {
        String cpf = "99999999901";
        PessoaDto data = new PessoaDto("Marcus", cpf);
        this.createPessoa(data);
        Optional<Pessoa> result = this.pessoaRepository.findByCpf(cpf);
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get pessoa from database when cpf not exists")
    void findByCpfNotSuccess() {
        String cpf = "99999999901";
        Optional<Pessoa> result = this.pessoaRepository.findByCpf(cpf);
        assertThat(result.isEmpty()).isTrue();
    }

    private Pessoa createPessoa(PessoaDto data) {
        Pessoa newPessoa = new Pessoa(data);
        this.entityManager.persist(newPessoa);
        return newPessoa;
    }
}