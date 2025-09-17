package com.devagi.meuprojeto.controller;

// Classe controladora da API REST


import com.devagi.meuprojeto.model.Cliente;
import com.devagi.meuprojeto.repository.ClienteRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que a classe expõe uma API rest -> mais atual e comum após a criação do JSON. REST é um tipo de manipulação de API usando HTTP
@RequestMapping("/clientes") // define o caminho base da API (a rota base)
public class ClienteController {

    private final ClienteRepository repository;
    /*
    Aqui estamos criando uma relação/injeção de dependencia
    O Spring boot injeta a implementação concreta do ClienteRepository no construtor do ClienteController
     */
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @GetMapping //Define o metodo GET HTTP -> para "buscar"
    public List<Cliente> listar(){
        return repository.findAll(); // ->  Aqui criamos o metodo que irá buscar na API a lista de clientes e vai nos retornar um List do tipo Cliente com todos os clientes no repositorio
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){ //metodo para buscar um cliente especifico pelo seu id, onde o @PathVariable pega valores da URL
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
    }

    @PostMapping // define o metodo POST HTTP para adicionar/postar
    public Cliente salvar(@RequestBody Cliente cliente){ // o @RequestBody converte o JSON da requisição em um objeto java, no caso o Cliente
        return repository.save(cliente);
    }

    @PutMapping("/{id}") // definie o metodo PUT HTTP para atualizar com parametros, nesse caso atualizar um cliente pela ID
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente dados){ // Metodo retornara um save de Cliente a partir do caminho (@Path...) e utilizara o JSON (@Request...) do objeto Cliente
        Cliente cliente = repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(dados.getNome()); // objeto cliente, settando o nome como paramaetro passando o objeto dados que contem nome onde usamos o get para pegar esse nome e poder armazenar em cliente
        cliente.setEmail(dados.getEmail());
        return repository.save(cliente); //  fazendo um save no nosso repositorio desse cliente
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
