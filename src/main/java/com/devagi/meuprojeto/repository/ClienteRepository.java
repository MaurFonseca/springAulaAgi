package com.devagi.meuprojeto.repository;

import com.devagi.meuprojeto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


// Classe de interface de repositório JPA onde vamos implementar ClienteController para fazer a persistencia de dados do banco de dados. No JPA já tem toda a lógica para implementarmos isso.

public interface ClienteRepository extends JpaRepository<Cliente, Long> { // em JpaRepository nós adicionamos como "parametro" primeiro a entidade desse dado e depois o tipo da chave primaria, no caso LONG pois em cliente a chave primaria é um Long

}
