package utils;

public class NoSuchLevelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2090483166697214035L;
	public NoSuchLevelException() {
		this("There is no such level stored.");
	}
	public NoSuchLevelException(String message) {
		super(message);
	}
}
