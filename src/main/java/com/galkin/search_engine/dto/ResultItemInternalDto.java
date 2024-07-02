package com.galkin.search_engine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ResultItemInternalDto {
    private String link;
    private String description;
}
