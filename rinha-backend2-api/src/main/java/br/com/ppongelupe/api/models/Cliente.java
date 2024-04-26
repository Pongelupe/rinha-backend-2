package br.com.ppongelupe.api.models;

import java.util.List;

import br.com.ppongelupe.api.exceptions.ClienteSemSaldoException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

	@Id
	@Column
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int limite;

	@Column(nullable = false)
	@Builder.Default
	private int saldo = 0;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idCliente")
	private List<Transacao> transacoes;
	
	
	public void debitar(int valor) {
		var novoSaldo = saldo - valor;
		if (novoSaldo < 0 && novoSaldo * -1 > limite) {
			throw new ClienteSemSaldoException(id);
		} else {
			this.saldo -= valor;
		}
	}

	public void creditar(int valor) {
		this.saldo += valor;
	}
	
}
