package com.galkin.search_engine.client.google;

import com.galkin.search_engine.client.SearchClient;
import com.galkin.search_engine.client.google.dto.GoogleResponseDto;
import com.galkin.search_engine.dto.ResultItemInternalDto;
import com.galkin.search_engine.exception.GoogleClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoogleSearchClient implements SearchClient {

    @Value("${google.api-key}")
    private String apiKey;

    @Override
    public String getName() {
        return "google";
    }

    @Override
    public List<ResultItemInternalDto> search(String word) {
        RestClient restClient = RestClient.create();
        GoogleResponseDto responseDto = restClient
                .get()
                .uri(String.format("https://google.serper.dev/search?q=%s&hl=en&gl=us&google_domain=google.com", word))
                .header("X-API-KEY", apiKey)
                .header("Content-Type", "application/json")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new GoogleClientException(response.getStatusCode());
                })
                .body(GoogleResponseDto.class);

        return responseDto.getOrganic().stream().map(item -> new ResultItemInternalDto()
                .setDescription(item.getTitle())
                .setLink(item.getLink()))
                .collect(Collectors.toList());
    }
}
