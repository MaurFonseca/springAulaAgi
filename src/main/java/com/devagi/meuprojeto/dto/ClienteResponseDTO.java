/*
Classe para filtrarmos a resposta da API de modo que não mostremos na API dados sensíveis.
 */

package com.devagi.meuprojeto.dto;

import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    //não vamos expor senha
}
