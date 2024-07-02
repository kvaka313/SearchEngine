package com.galkin.search_engine.exception;

import org.springframework.http.HttpStatusCode;

public class GoogleClientException extends RuntimeException {
    public GoogleClientException(HttpStatusCode code) {
        super(String.format("Error during request to Google with code %s and headers %s", code));
    }
}
