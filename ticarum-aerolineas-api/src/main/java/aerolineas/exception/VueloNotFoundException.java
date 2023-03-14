package aerolineas.exception;

@SuppressWarnings("serial")
public class VueloNotFoundException extends RuntimeException {
	public VueloNotFoundException() {
        super();
    }

    public VueloNotFoundException(String message) {
        super(message);
    }

    public VueloNotFoundException(long id) {
        super("Flight not found with ID: " + id);
    }
}
