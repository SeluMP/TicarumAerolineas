package aerolineas.exception;

@SuppressWarnings("serial")
public class AerolineaNotFoundException extends RuntimeException {
	public AerolineaNotFoundException() {
        super();
    }

    public AerolineaNotFoundException(String message) {
        super(message);
    }

    public AerolineaNotFoundException(long id) {
        super("Airline not found with ID: " + id);
    }
}
