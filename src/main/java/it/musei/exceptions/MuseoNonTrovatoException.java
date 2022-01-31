package it.musei.exceptions;

public class MuseoNonTrovatoException extends Exception {

	private static final long serialVersionUID = 1L;

	public MuseoNonTrovatoException(String message) {
		super(message);
	}

	public MuseoNonTrovatoException() {
		super("Il museo specificato non è stato trovato!");
	}
}