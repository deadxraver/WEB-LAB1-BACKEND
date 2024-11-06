import com.fastcgi.FCGIInterface;
import data.RequestData;
import exceptions.*;

public class RequestHandler {

	public static RequestData readRequest() throws NotANumberException, WrongNumberOfArgumentsException, RepeatingArgumentsException, MethodNotAllowedException {
		Main.logger.info(FCGIInterface.request.params.getProperty("REQUEST_URI"));
		if (!FCGIInterface.request.params.getProperty("REQUEST_METHOD").equals("GET")
				|| !FCGIInterface.request.params.getProperty("REQUEST_URI").split("\\?")[0].equals("/fcgi-bin/server.jar")
		) {
			Main.logger.severe("Wrong method or URL!");
			throw new MethodNotAllowedException();
		}
		Main.logger.info("Received data: %s".formatted(FCGIInterface.request.params.getProperty("QUERY_STRING")));
		return RequestData.parse(FCGIInterface.request.params.getProperty("QUERY_STRING"));

	}

}
