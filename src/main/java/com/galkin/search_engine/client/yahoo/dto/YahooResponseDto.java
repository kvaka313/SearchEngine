package com.galkin.search_engine.client.yahoo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class YahooResponseDto {
    @JsonProperty(value = "organic_results")
    List<YahooResultItemDto> organicResults;
}
