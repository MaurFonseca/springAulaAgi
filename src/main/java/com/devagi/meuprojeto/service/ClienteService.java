/*
Classe para serviços de cliente
CRUD
 */

package com.devagi.meuprojeto.service;

import com.devagi.meuprojeto.dto.ClienteRequestDTO;
import com.devagi.meuprojeto.dto.ClienteResponseDTO;
import com.devagi.meuprojeto.model.Cliente;
import com.devagi.meuprojeto.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // para declararmos como uma classe de serviço.
public class ClienteService {

    private final ClienteRepository repository; //

    /*
    Aqui estamos criando uma relação/injeção de dependencia
    O Spring boot injeta a implementação concreta do ClienteRepository no construtor do ClienteService que será usado pelo Cliente Controller
     */

    public ClienteService (ClienteRepository repository){
        this.repository = repository;
    }

    //Convesão do Cliente em DTO
    public ClienteResponseDTO toResponseDTO(Cliente cliente){
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setEmail(cliente.getEmail());
        dto.setNome(cliente.getNome());
        dto.setId(cliente.getId());
        return dto;
    }

    public List<ClienteResponseDTO> listar(){
        return repository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList()); // ->  Aqui criamos o metodo que irá buscar na API a lista de clientes e vai nos retornar um List do tipo ClienteResponseDTO (que são todos os clientes com o filtro do response) com todos os clientes no repositorio
    }

    public ClienteResponseDTO buscar(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
        return toResponseDTO(cliente);
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        Cliente salvo = repository.save(cliente);
        return toResponseDTO(salvo);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto){
        Cliente cliente = repository.findById(id).orElseThrow(()->new RuntimeException("Cliente não encontrado"));
        if (dto.getSenha() != null && !dto.getSenha().isBlank()){
            cliente.setSenha(dto.getSenha()); // atualiza a senha apenas se tiver algum valor a ser atualizado
        }
        cliente.setNome(dto.getNome()); // objeto cliente, settando o nome como paramaetro passando o objeto dto que contem nome onde usamos o get para pegar esse nome e poder armazenar em cliente
        cliente.setEmail(dto.getEmail());
        Cliente atualizado = repository.save(cliente);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }


}
