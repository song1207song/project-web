package com.songha.projectweb.exception;

import com.songha.projectweb.domain.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :: exceptionHandler 구현부.
 * 각 custom exception 별 알맞은 처리 과정을 기술하였다.
 * - e.g. PageNotFoundException 발생 시 404 페이지로 redirect 를 유도하였다.
 */
@Slf4j
@ControllerAdvice
public class ProjectWebExceptionHandler {
    private static String PAGE_404 = "redirect:error/404";

    // PageNotFoundException 발생 시 404 redirect
    @ExceptionHandler(value = PageNotFoundException.class)
    public String handlePageNotFoundException(PageNotFoundException e) {
        log.error("ProjectWebExceptionHandler.handlePageNotFoundException :: {}", e.getMessage(), e);
        return PAGE_404;
    }

    //ProjectWebException 을 상속받은 exception 발생 시, ErrorResponse 변환하여 반환
    @ExceptionHandler(ProjectWebException.class)
    protected ResponseEntity<ErrorResponse> handleProjectWebException(ProjectWebException e) {
        log.error("ProjectWebExceptionHandler.handleProjectWebException :: {}", e.getMessage(), e);

        ErrorResponse response = ErrorResponse.create().status(e.getErrorCode()
                .getStatus()).code(e.getErrorCode().getCode()).errorCode(e.getErrorCode().getErrorCode()).message(e.toString());
        return new ResponseEntity<>(response, HttpStatus.resolve(e.getErrorCode().getStatus()));
    }

    //@Valid 시 발생하는 exception handling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("ProjectWebExceptionHandler.handleMethodArgumentNotValidException :: {}", e.getMessage(), e);

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    // HttpMethod exception handling
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("ProjectWebExceptionHandler.handleHttpRequestMethodNotSupportedException :: {}", e.getMessage(), e);

        ErrorResponse response = ErrorResponse.create().status(HttpStatus.METHOD_NOT_ALLOWED.value()).message(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //모든 exception handling 하여 ErrorResponse 형태로 변환
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleAllException(Exception e) {
        log.error("ProjectWebExceptionHandler.handleAllException :: {}", e.getMessage(), e);

        ErrorResponse response = ErrorResponse.create().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(e.toString());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
