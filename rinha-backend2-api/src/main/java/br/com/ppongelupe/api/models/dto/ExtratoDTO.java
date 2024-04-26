package br.com.ppongelupe.api.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtratoDTO {

	private SaldoExtratoDTO saldo;
	
	@JsonProperty("ultimas_transacoes")
	private List<TransacaoDTO> ultimasTransacoes;
	
}
