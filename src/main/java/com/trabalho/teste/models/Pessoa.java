package com.trabalho.teste.models;

import com.trabalho.teste.dto.PessoaDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    public Pessoa(PessoaDto data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
    }

}
