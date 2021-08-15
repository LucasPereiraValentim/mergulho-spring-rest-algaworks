package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DestinatarioInputModel {
	
	@NotBlank(message = "Nome do destinatario não pode ficar em branco")
	private String nome;

	@NotBlank(message = "Logradouro do destinatario não pode ficar em branco")
	private String logradouro;
	
	@NotBlank(message = "Número do destinatario não pode ficar em branco")
	private String numero;
	
	@NotBlank(message = "Complemento do destinatario não pode ficar em branco")
	private String complemento;
	
	@NotBlank(message = "Bairro do destinatario não pode ficar em branco")
	private String bairro;
}

