import data.Codes;
import data.ResponseData;


public class ResponseHandler {
	private static final String httpResponseTemplate = """
            HTTP/2 %d %s
            Content-Type: application/json
            Content-Length: %d

            %s
           """;

	public static void sendResponse(int code, ResponseData data) {
		System.out.printf(
				httpResponseTemplate,
				code,
				Codes.getName(code),
				data.toString().getBytes().length,
				data
		);
	}

}
