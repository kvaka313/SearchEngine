package com.galkin.search_engine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class SearchResultsDto {
    private List<ResultSearchItemDto> list;
    private String warning;
}
