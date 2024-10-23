package data;

public class Codes {
	public static int OK = 200;
	public static int BAD_REQUEST = 400;
	public static int METHOD_NOT_ALLOWED = 405;

	public static String getName(int code) {
		return switch (code) {
			case 200 -> "OK";
			case 400 -> "Bad Request";
			case 405 -> "Method Not Allowed";
			default -> null;
		};
	}
}
