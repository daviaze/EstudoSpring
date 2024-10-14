package estudo.spring.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ProcessError {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity processError404(){
        return ResponseEntity.notFound().build();
    }

    //Tratamento que irá ser disparado quando houver erros de validação no post ou put
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity processError400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(FieldErrorsValidation::new).toList());
    }

    //Record para qual o erro será convertido no tratamento
    private record FieldErrorsValidation(String field, String message){
        public FieldErrorsValidation(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
