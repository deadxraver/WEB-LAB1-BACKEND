package data;

import exceptions.*;

public record RequestData(int x, float y, int r) {
	public static RequestData parse(String line) throws NotANumberException, WrongNumberOfArgumentsException, RepeatingArgumentsException {
		Integer x = null, r = null;
		Float y = null;
		String[] data = line.replaceAll("&", "=").split("=");
		if (data.length != 6) {
			throw new WrongNumberOfArgumentsException();
		}
		for (int i = 0; i < data.length; i += 2) {
			try {
				if (data[i].equals("x")) {
					x = Integer.parseInt(data[i + 1]);
				}
				if (data[i].equals("y")) {
					if (data[i + 1].contains("5.")  && data[i + 1].length() > 2) {
						char[] s = data[i + 1].toCharArray();
						for (int j = 2; j < s.length; j++) {
							if (s[j] != '0') throw new NotANumberException("y");
						}
					}
					else if (data[i + 1].contains("-3.") && data[i + 1].length() > 3) {
						char[] s = data[i + 1].toCharArray();
						for (int j = 3; j < s.length; j++) {
							if (s[j] != '0') throw new NotANumberException("y");
						}
					}
					y = Float.parseFloat(data[i + 1]);
				}
				if (data[i].equals("r")) {
					r = Integer.parseInt(data[i + 1]);
				}
			} catch (NumberFormatException e) {
				throw new NotANumberException(data[i]);
			}
		}
		if (x == null || y == null || r == null) throw new RepeatingArgumentsException();
		return new RequestData(x, y, r);
	}
}
