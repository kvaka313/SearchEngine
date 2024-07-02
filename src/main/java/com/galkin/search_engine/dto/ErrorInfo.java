package com.galkin.search_engine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter@Accessors(chain = true)
public class ErrorInfo {
    private Long timestamp;
    private String message;
    private String developerMessage;
}
