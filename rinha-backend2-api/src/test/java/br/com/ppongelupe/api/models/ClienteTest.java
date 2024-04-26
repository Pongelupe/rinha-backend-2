package br.com.ppongelupe.api.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ppongelupe.api.exceptions.ClienteSemSaldoException;

class ClienteTest {
	
	private Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		cliente = Cliente.builder()
				.id(69)
				.nome("thomas sankara")
				.saldo(10)
				.limite(100)
				.build();
	}

	@Test
	void testCreditar() {
		cliente.creditar(5);
		assertEquals(15, cliente.getSaldo());
	}
	
	@Test
	void testDebitarComSaldo() {
		cliente.debitar(5);
		assertEquals(5, cliente.getSaldo());
	}
	
	@Test
	void testDebitarSemSaldoComLimite() {
		cliente.debitar(15);
		assertEquals(-5, cliente.getSaldo());
	}
	
	@Test
	void testDebitarSemSaldoSemLimite() {
		try {
			cliente.debitar(1500);		
			fail();
		} catch (ClienteSemSaldoException e) {
			assertEquals("O cliente de id 69 está sem saldo", e.getMessage());
		}
	}

}
