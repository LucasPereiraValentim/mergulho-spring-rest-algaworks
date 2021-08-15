package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destinatario {
	
	@NotBlank(message = "Nome do destinatario não pode ficar em branco")
	@Column(name = "destinatario_nome")	
	private String nome;
	@NotBlank(message = "Logradouro do destinatario não pode ficar em branco")
	@Column(name = "destinatario_logradouro")
	private String logradouro;
	
	@NotBlank(message = "Número do destinatario não pode ficar em branco")
	@Column(name = "destinatario_numero")
	private String numero;
	
	@NotBlank(message = "Complemento do destinatario não pode ficar em branco")
	@Column(name = "destinatario_complemento")
	private String complemento;
	
	@NotBlank(message = "Bairro do destinatario não pode ficar em branco")
	@Column(name = "destinatario_bairro")
	private String bairro;
}
