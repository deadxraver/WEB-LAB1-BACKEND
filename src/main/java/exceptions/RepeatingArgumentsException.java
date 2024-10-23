package exceptions;

public class RepeatingArgumentsException extends Exception {
	@Override
	public String getMessage() {
		return "Arguments cannot be repeated!";
	}
}
