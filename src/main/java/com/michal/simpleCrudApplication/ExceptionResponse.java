package com.michal.simpleCrudApplication;

import lombok.Data;

@Data
public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;
}
