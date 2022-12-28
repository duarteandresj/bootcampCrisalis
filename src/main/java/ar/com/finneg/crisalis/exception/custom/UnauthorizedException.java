package ar.com.finneg.crisalis.exception.custom;

public class UnauthorizedException extends RuntimeException {
	private static final String DESCRIPTION = "Credential invalid (401)";

	public UnauthorizedException(String message) {
		super(DESCRIPTION + ", " + message);}
	
}
