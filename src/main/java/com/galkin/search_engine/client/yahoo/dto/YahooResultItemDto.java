package com.galkin.search_engine.client.yahoo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class YahooResultItemDto {
    private String title;
    private String link;
}
