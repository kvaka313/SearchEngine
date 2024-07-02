package com.galkin.search_engine.exception.handler;

import com.galkin.search_engine.dto.ErrorInfo;
import com.galkin.search_engine.exception.GoogleClientException;
import com.galkin.search_engine.exception.ParseException;
import com.galkin.search_engine.exception.SearchException;
import com.galkin.search_engine.exception.YahooClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerService {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            SearchException.class})
    @ResponseBody
    public ErrorInfo searchExceptionHandler(SearchException ex) {
        return new ErrorInfo().setTimestamp(System.currentTimeMillis())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            ParseException.class})
    @ResponseBody
    public ErrorInfo parseExceptionHandler(ParseException ex) {
        return new ErrorInfo().setTimestamp(System.currentTimeMillis())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            GoogleClientException.class})
    @ResponseBody
    public ErrorInfo parseExceptionHandler(GoogleClientException ex) {
        return new ErrorInfo().setTimestamp(System.currentTimeMillis())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            YahooClientException.class})
    @ResponseBody
    public ErrorInfo parseExceptionHandler(YahooClientException ex) {
        return new ErrorInfo().setTimestamp(System.currentTimeMillis())
                .setMessage(ex.getMessage())
                .setDeveloperMessage(ex.toString());
    }
}
