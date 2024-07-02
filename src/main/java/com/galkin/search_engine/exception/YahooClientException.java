package com.galkin.search_engine.exception;

import org.springframework.http.HttpStatusCode;

public class YahooClientException extends RuntimeException {
    public YahooClientException(HttpStatusCode code) {
        super(String.format("Error during request to Yahoo with code %s and headers %s", code));
    }
}
