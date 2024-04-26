package br.com.ppongelupe.api.services;

import org.springframework.stereotype.Service;

import br.com.ppongelupe.api.exceptions.EntityNotFoundException;
import br.com.ppongelupe.api.models.Cliente;
import br.com.ppongelupe.api.models.Transacao;
import br.com.ppongelupe.api.models.dto.SaldoDTO;
import br.com.ppongelupe.api.models.dto.TransacaoDTO;
import br.com.ppongelupe.api.repositories.ClientesRepository;
import br.com.ppongelupe.api.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientesService {

	private static final String TIPO_TRANSACAO_DEBITO = "d";

	private final ClientesRepository clientesRepository;
	
	private final TransacaoRepository transacaoRepository;

	public SaldoDTO insereTransacao(int id, TransacaoDTO transacao) {
		var cliente = getClienteById(id);
		
		if (transacao.getTipo().equals(TIPO_TRANSACAO_DEBITO)) {
			cliente.debitar(transacao.getValor());
		} else {
			cliente.creditar(transacao.getValor());
		}
		
		clientesRepository.save(cliente);
		transacaoRepository.save(Transacao.builder()
				.cliente(cliente)
				.valor(transacao.getValor())
				.tipoTransacao(transacao.getTipo())
				.descricao(transacao.getDescricao())
				.build());
		
		return SaldoDTO.builder()
				.saldo(cliente.getSaldo())
				.limite(cliente.getLimite())
				.build();
	}
	
	private Cliente getClienteById(int id) {
		return clientesRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente de id " + id + " não encontrado!"));
	}
	
	
}
