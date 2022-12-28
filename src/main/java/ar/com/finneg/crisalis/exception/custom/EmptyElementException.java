package ar.com.finneg.crisalis.exception.custom;

public class EmptyElementException extends RuntimeException {
	private final static String DESCRIPTION="Empty element (400)";
	
	public EmptyElementException(String message) {
		super(DESCRIPTION +", "+message); 
		
	}

}
