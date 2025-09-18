package com.devagi.meuprojeto.model;

import jakarta.persistence.*;

import lombok.*;

@Entity //mapeia a classe como uma entidade
@Data // (Lombok) gera os getters, setters, hashCode, equals e toString.
@NoArgsConstructor // (Lombok) gera construtor sem argumento, deve ser sempre gerado primeiro antes dos demais
@AllArgsConstructor // (Lombok) gera construtor com todos atributos/argumentos
public class Cliente {
    @Id //marca o campo como chave primaria do BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // vai gerar o valor de ID automaticamente
    private Long id; //criamos uma varíavel id que vai receber os @ acima

    private String nome;
    private String email;
    private String senha;
}
