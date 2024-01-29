package cursos.api.modules.cursos.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cursos.api.modules.cursos.exceptions.dto.MethodNotValidDTO;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class MethodNotValid {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> error400(MethodArgumentNotValidException methodArgumentNotValidException){
        var errors = methodArgumentNotValidException.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(MethodNotValidDTO::new).toList());
    }
}
