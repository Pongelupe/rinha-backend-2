package br.com.ppongelupe.api.models.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaldoExtratoDTO {

	private int total;
	
	@JsonProperty("data_extrato")
	private LocalDateTime dataExtrato;

	private int limite;
	
}
