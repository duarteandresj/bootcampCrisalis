package ar.com.finneg.crisalis.exception.custom;

public class NotCreatedException extends RuntimeException{
private final static String DESCRIPTION="Error in created element (400)";
	
public NotCreatedException(String message) {
		super(DESCRIPTION +", "+message); 
		
	}
}
