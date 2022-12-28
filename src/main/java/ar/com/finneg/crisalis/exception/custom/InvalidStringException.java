package ar.com.finneg.crisalis.exception.custom;

public class InvalidStringException extends RuntimeException {
private final static String DESCRIPTION="Invalid attribute (400)";
	
	public InvalidStringException(String message) {
		super(DESCRIPTION +", "+message); 
		
	}

}
