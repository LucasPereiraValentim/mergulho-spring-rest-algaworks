package com.algaworks.algalog.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInputModel {
	
	@NotNull
	@Valid
	private ClienteInputModel cliente;
	
	@Valid
	@NotNull
	private DestinatarioInputModel destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
}
