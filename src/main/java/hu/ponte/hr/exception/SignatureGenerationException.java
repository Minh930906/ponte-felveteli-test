package hu.ponte.hr.exception;

public class SignatureGenerationException extends RuntimeException {
    public SignatureGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
