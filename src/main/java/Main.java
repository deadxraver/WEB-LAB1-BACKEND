import com.fastcgi.FCGIInterface;
import data.Codes;
import data.RequestData;
import data.ResponseData;
import exceptions.*;
import validators.Checker;
import validators.Validator;

import java.time.LocalDateTime;

import java.util.logging.Logger;

public class Main {

	public static final Logger logger = Logger.getLogger("main");

	public static void main(String... args) {
		logger.info("server started");
		while (new FCGIInterface().FCGIaccept() >= 0) {
			logger.info("Received request");
			LocalDateTime startTime = LocalDateTime.now();
			logger.info(String.format("Started executing script at %s", startTime));
			RequestData requestData;
			try {
				requestData = RequestHandler.readRequest();
				if (!Validator.check(requestData)) throw new ArgumentsOutOfBounds("Arguments out of bounds!");
				logger.info(String.format("Received request: %s", requestData));
			} catch (NotANumberException | RepeatingArgumentsException | WrongNumberOfArgumentsException | ArgumentsOutOfBounds e) {
				logger.severe(e.getMessage());
				LocalDateTime endTime = LocalDateTime.now();
				int executionTime = endTime.getNano() / 1_000_000 - startTime.getNano() / 1_000_000;
				ResponseHandler.sendResponse(Codes.BAD_REQUEST, new ResponseData(
						0,
						0,
						0,
						false,
						endTime,
						executionTime
				));
				continue;
			} catch (MethodNotAllowedException e) {
				logger.severe("Only \"GET\" methods are supported");
				LocalDateTime endTime = LocalDateTime.now();
				int executionTime = endTime.getNano() / 1_000_000 - startTime.getNano() / 1_000_000;
				ResponseHandler.sendResponse(Codes.METHOD_NOT_ALLOWED, new ResponseData(
						0,
						0,
						0,
						false,
						endTime,
						executionTime
				));
				continue;
			}
			boolean hit = Checker.check(requestData);
			LocalDateTime endTime = LocalDateTime.now();
			int executionTime = endTime.getNano() / 1_000_000 - startTime.getNano() / 1_000_000;
			ResponseData responseData = new ResponseData(
					requestData.x(),
					requestData.y(),
					requestData.r(),
					hit,
					endTime,
					executionTime
			);
			ResponseHandler.sendResponse(Codes.OK, responseData);
		} // "http://localhost:24928/fcgi-bin/server.jar?x=1"

	}

}
