package exceptions;

public class WrongNumberOfArgumentsException extends Exception {
	@Override
	public String getMessage() {
		return "Wrong number of arguments!";
	}
}
