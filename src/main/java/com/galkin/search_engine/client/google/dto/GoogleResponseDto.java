package com.galkin.search_engine.client.google.dto;

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
public class GoogleResponseDto {
    @JsonProperty(value = "organic")
    List<GoogleResultItemDto> organic;
}
