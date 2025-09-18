/*
Classe para fazermos o filtro de recebimento de informações de cliente para que possamos definir somente os dados que queremos persistir no banco
Nesse caso estamos persistindo todos os dados.

Lembrando esse sistema é apenas um exercício não é o correto persistismo no banco a senha orginal, deve persistir apenas o hash
 */

package com.devagi.meuprojeto.dto;

import lombok.Data;

@Data
public class ClienteRequestDTO {

    private String nome;
    private String email;
    private String senha;
}
