package com.devagi.meuprojeto.controller;

// Classe controladora da API REST


import com.devagi.meuprojeto.dto.ClienteRequestDTO;
import com.devagi.meuprojeto.dto.ClienteResponseDTO;
import com.devagi.meuprojeto.model.Cliente;
import com.devagi.meuprojeto.repository.ClienteRepository;
import com.devagi.meuprojeto.service.ClienteService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que a classe expõe uma API rest -> mais atual e comum após a criação do JSON. REST é um tipo de manipulação de API usando HTTP
@RequestMapping("/clientes") // define o caminho base da API (a rota base)
public class ClienteController {

    @Autowired
    private final ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }

    @GetMapping //Define o metodo GET HTTP -> para "buscar"
    public List<ClienteResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscar(@PathVariable Long id){ //metodo para buscar um cliente especifico pelo seu id, onde o @PathVariable pega valores da URL
        return service.buscar(id);
    }

    @PostMapping // define o metodo POST HTTP para adicionar/postar
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO cliente){ // o @RequestBody converte o JSON da requisição em um objeto java, no caso o Cliente
        return service.salvar(cliente);
    }

    @PutMapping("/{id}") // definie o metodo PUT HTTP para atualizar com parametros, nesse caso atualizar um cliente pela ID
    public ClienteResponseDTO atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dados){ // Metodo retornara um save de Cliente a partir do caminho (@Path...) e utilizara o JSON (@Request...) do objeto Cliente
        return service.atualizar(id, dados);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
