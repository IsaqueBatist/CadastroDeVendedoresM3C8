package dark.com.demo.services.exceptions;

import java.time.Instant;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class ResouceExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErros> validationException(MethodArgumentNotValidException exception, HttpServletRequest request) {

    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    ValidationErros error = new ValidationErros();
    error.setTimestamp(Instant.now());
    error.setStatus(status.value());
    error.setError("Validation Exception");
    error.setMessage(exception.getMessage());
    error.setPath(request.getRequestURI());

    exception.getBindingResult()
            .getFieldErrors()
            .forEach(e -> error.addError(e.getDefaultMessage()));

    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ValidationErros> entityNotFoundEntity(EntityNotFoundException exception, HttpServletRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;

    ValidationErros error = new ValidationErros();
    error.setTimestamp(Instant.now());
    error.setStatus(status.value());
    error.setError("Resouce not faound");
    error.setMessage(exception.getMessage());
    error.setPath(request.getRequestURI());
    
    return ResponseEntity.status(status).body(error);
  }
}
