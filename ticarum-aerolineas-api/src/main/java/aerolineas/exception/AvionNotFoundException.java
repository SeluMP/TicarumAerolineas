package aerolineas.exception;

@SuppressWarnings("serial")
public class AvionNotFoundException extends RuntimeException {
	public AvionNotFoundException() {
        super();
    }

    public AvionNotFoundException(String message) {
        super(message);
    }

    public AvionNotFoundException(long id) {
        super("Plane not found with ID: " + id);
    }
}
