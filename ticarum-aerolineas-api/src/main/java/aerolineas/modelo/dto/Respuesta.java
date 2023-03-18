package aerolineas.modelo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Respuesta {
	public static final int OK = 200;
	public static final int NO_CONTENT = 204;
    public static final int NOT_FOUND = 404;
    public static final int BAD_REQUEST = 400;
 
    public static final String NO_MESSAGE = "";
 
    private Error error;
 
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Error {
        private long errorCode;
        private String message;
    }
 
    public static Respuesta noErrorResponse() {
        return new Respuesta(new Error(OK, NO_MESSAGE));
    }
 
    public static Respuesta errorResonse(int errorCode, String errorMessage) {
        return new Respuesta(new Error(errorCode, errorMessage));
    }
}
