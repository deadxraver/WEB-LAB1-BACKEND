package data;

import java.time.LocalDateTime;

public record ResponseData(
		int x,
		float y,
		int r,
		boolean hit,
		LocalDateTime currentTime,
		int executionTime
) {
	@Override
	public String toString() {
		return String.format("""
				{"x": "%d",
				"y": "%f",
				"r": "%d",
				"hit": "%b",
				"currentTime": "%s",
				"executionTime": "%d"}
				""", x, y, r, hit, currentTime, executionTime);
	}
}
