package com.galkin.search_engine.service.impl;

import com.galkin.search_engine.client.SearchClient;
import com.galkin.search_engine.dto.ResultItemInternalDto;
import com.galkin.search_engine.dto.SearchResultsInternalDto;
import com.galkin.search_engine.service.SearchClientProvider;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class SearchClientProviderImpl implements SearchClientProvider {

    @Override
    @Async("searchThreadPool")
    public Future<SearchResultsInternalDto> executeSearch(SearchClient client, List<String> searchTokens) {
        SearchResultsInternalDto dto = new SearchResultsInternalDto();
        dto.setErrorMessage(null);
        List<ResultItemInternalDto> dtos = new ArrayList<>();
        for (String word: searchTokens) {
            try {
                dtos.addAll(client.search(word));
            } catch(Exception e) {
                String errorMessage = String.format("Error during search by word %s. Error message is %s. ", word, e.getMessage());
                if (dto.getErrorMessage() == null) {
                    dto.setErrorMessage(errorMessage);
                } else {
                    dto.setErrorMessage(dto.getErrorMessage() + errorMessage);
                }
            }

        }
        dto.setList(dtos);
        return new AsyncResult<>(dto).completable();
    }
}
