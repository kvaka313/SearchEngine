package com.galkin.search_engine.client.yahoo;

import com.galkin.search_engine.client.SearchClient;
import com.galkin.search_engine.client.yahoo.dto.YahooResponseDto;
import com.galkin.search_engine.dto.ResultItemInternalDto;
import com.galkin.search_engine.exception.YahooClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class YahooSearchClient implements SearchClient {
    @Value("${yahoo.api-key}")
    private String apiKey;

    @Override
    public String getName() {
        return "yahoo";
    }

    @Override
    public List<ResultItemInternalDto> search(String word) {
        RestClient restClient = RestClient.create();
        YahooResponseDto responseDto = restClient
                .get()
                .uri(String.format("https://serpapi.com/search.json?engine=yahoo&p=%s&api_key=%s", word, apiKey))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new YahooClientException(response.getStatusCode());
                })
                .body(YahooResponseDto.class);

        return responseDto.getOrganicResults().stream().map(item -> new ResultItemInternalDto()
                        .setDescription(item.getTitle())
                        .setLink(item.getLink()))
                .collect(Collectors.toList());
    }
}
