package org.kshrd.rest_api2.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFountException.class)
    ProblemDetail handlerNotFoundException(NotFountException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }
    @ExceptionHandler(FieldEmptyException.class)
    ProblemDetail handlerFieldEmptyException(FieldEmptyException e){
//        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
        problemDetail.setTitle("ah chkea");
        return problemDetail;
    }
    @ExceptionHandler(BadRequestException.class)
    ProblemDetail handlerBadRequestEmptyException(BadRequestException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );
        problemDetail.setTitle("ah chkea");
        return problemDetail;
    }
}
