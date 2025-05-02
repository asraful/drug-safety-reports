package com.tepsivo.pv.report.web.api.endpoint;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class APIException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus status;

    public APIException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public APIException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
