package com.songha.projectweb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProjectWebExceptionHandler {
    private static String PAGE_404 = "redirect:"; // todo
    private static String PAGE_500 = "redirect:";

    @ExceptionHandler(value = NotFoundException.class)
    public String notfound(Exception ex) {
        return PAGE_404;
    }

    @ExceptionHandler(value = ErrorProjectWebException.class)
    public String error(Exception ex) {
        return PAGE_500;
    }
}
