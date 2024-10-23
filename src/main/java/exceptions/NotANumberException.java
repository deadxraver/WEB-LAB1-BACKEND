package exceptions;

public class NotANumberException extends Exception {

	public NotANumberException(String variable) {
		super(String.format("Variable %s is not a number!", variable));
	}
}
