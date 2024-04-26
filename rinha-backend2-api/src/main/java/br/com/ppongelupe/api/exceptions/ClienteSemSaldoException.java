package br.com.ppongelupe.api.exceptions;

public class ClienteSemSaldoException extends UnprocessableEntityException { // NOSONAR

	private static final long serialVersionUID = 7690820461958018431L;

	public ClienteSemSaldoException(int id) {
		super("O cliente de id " + id + " está sem saldo");
	}

}
