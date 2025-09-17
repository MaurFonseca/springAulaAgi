package com.devagi.meuprojeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //mapeia a classe como uma entidade
@Data // gera os getters, setters, hashCode, equals e toString.
@NoArgsConstructor // gera construtor sem argumento, deve ser sempre gerado primeiro antes dos demais
@AllArgsConstructor // gera construtor com todos atributos/argumentos
public class Cliente {


    @Id //marca o campo como chave primaria do BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // vai gerar o valor de ID automaticamente
    private Long id; //criamos uma varíavel id que vai receber os @ acima

    private String nome;
    private String email;

    

}
