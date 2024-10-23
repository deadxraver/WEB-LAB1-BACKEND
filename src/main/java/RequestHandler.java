import com.fastcgi.FCGIInterface;
import data.RequestData;
import exceptions.*;

public class RequestHandler {

	public static RequestData readRequest() throws NotANumberException, WrongNumberOfArgumentsException, RepeatingArgumentsException, MethodNotAllowedException {

		if (!FCGIInterface.request.params.getProperty("REQUEST_METHOD").equals("GET")) {
			Main.logger.info(FCGIInterface.request.params.getProperty("REQUEST_METHOD"));
			throw new MethodNotAllowedException();
		}
		Main.logger.info("Received data: %s".formatted(FCGIInterface.request.params.getProperty("QUERY_STRING")));
		return RequestData.parse(FCGIInterface.request.params.getProperty("QUERY_STRING"));

	}

}
