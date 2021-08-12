package com.michal.simpleCrudApplication;


import com.michal.simpleCrudApplication.exception.InvalidOperationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ControllerAdviceHandler {

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionResponse handleResourceNotFound(final InvalidOperationException exception,
                                             final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());

        return error;
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ExceptionResponse handleUnexpectedExceptions(final InvalidOperationException exception,
                                                 final HttpServletRequest request) {

        log.error(exception.getMessage());
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage("Internal Server Error [500]");
        error.setRequestedURI(request.getRequestURI());

        return error;
    }
}
