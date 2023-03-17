package aerolineas.modelo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Respuesta {
	public static final int NO_ERROR = 0;
    public static final int NOT_FOUND = 101;
 
    public static final String NO_MESSAGE = "";
 
    private Error error;
 
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Error {
        private long errorCode;
        private String message;
    }
 
    public static Respuesta noErrorResponse() {
        return new Respuesta(new Error(NO_ERROR, NO_MESSAGE));
    }
 
    public static Respuesta errorResonse(int errorCode, String errorMessage) {
        return new Respuesta(new Error(errorCode, errorMessage));
    }
}
