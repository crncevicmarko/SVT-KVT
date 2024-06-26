package rs.ac.uns.ftn.svtvezbe06.exceptionhandling;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorObject {

    public final String path;
    public final String message;
    public final LocalDateTime timestamp;
    public final Integer statusCode;
    public final String statusReason;

    public final Map<String, String> errors;

    public ErrorObject(HttpServletRequest request, String message, HttpStatus statusCode) {
        this.path = request.getRequestURI();
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode.value();
        this.statusReason = statusCode.getReasonPhrase();
        this.errors = new HashMap<>();
    }

    public ErrorObject(HttpServletRequest request, String message, HttpStatus statusCode,
                       Map<String, String> errors) {
        this.path = request.getRequestURI();
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode.value();
        this.statusReason = statusCode.getReasonPhrase();
        this.errors = errors;
    }

}
