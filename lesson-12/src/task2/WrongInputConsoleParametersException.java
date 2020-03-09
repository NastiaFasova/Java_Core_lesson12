package task2;

public class WrongInputConsoleParametersException extends Exception{
	private String message;
	public WrongInputConsoleParametersException(String message) {
		super(message);
	}
}
