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


    // Por algum motivo o @Data não estava funcionando 100% então para evitar problemas criei os getter e setter manualmente
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
