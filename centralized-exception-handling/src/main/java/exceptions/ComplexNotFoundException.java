package exceptions;

public class ComplexNotFoundException extends RuntimeException {

	public ComplexNotFoundException() {
		super("Required Complex not found!");
	}
}
