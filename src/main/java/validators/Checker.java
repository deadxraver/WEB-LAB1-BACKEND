package validators;

import data.RequestData;

public class Checker {
	private static int x;
	private static float y;
	private static int r;

	public static boolean check(RequestData requestData) {
		Checker.x = requestData.x();
		Checker.y = requestData.y();
		Checker.r = requestData.r();
		return checkFirst() || checkSecond() || checkThird() || checkFourth();
	}

	private static boolean checkFirst() {
		if (x >= 0 && y >= 0) {
			return x <= r / 2 && y <= r;
		}
		return false;
	}

	private static boolean checkSecond() {
		return false;
	}

	private static boolean checkThird() {
		if (x <= 0 && y <= 0) { // y = -x -r /2
			return y == -x - (float)(r) / 2;
		}
		return false;
	}

	private static boolean checkFourth() {
		if (x <= 0 && y >= 0) {
			return x * x + y * y <= (float) (r * r);
		}
		return false;
	}

}
