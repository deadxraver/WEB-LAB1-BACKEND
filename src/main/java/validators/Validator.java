package validators;

import data.RequestData;

public class Validator {
	public static boolean check(RequestData requestData) {
		return requestData.x() >= -3 && requestData.x() <= 5 &&
				requestData.y() >= -3 && requestData.y() <= 5 &&
				requestData.r() >= 0 && requestData.r() <= 5;
	}
}
