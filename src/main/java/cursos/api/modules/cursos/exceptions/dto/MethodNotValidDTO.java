package cursos.api.modules.cursos.exceptions.dto;

import org.springframework.validation.FieldError;

public record MethodNotValidDTO(String field, String message) {
    public MethodNotValidDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
