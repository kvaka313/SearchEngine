package com.galkin.search_engine.service.impl;

import com.galkin.search_engine.client.SearchClient;
import com.galkin.search_engine.dto.SearchResultsInternalDto;
import com.galkin.search_engine.service.SearchClientProvider;
import com.galkin.search_engine.service.SearchProvider;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Service
@AllArgsConstructor
public class SearchProviderImpl implements SearchProvider {

    private List<SearchClient> clients;
    private SearchClientProvider provider;

    @Override
    public Map<String, SearchResultsInternalDto> searchByToken(List<String> searchTokens) {
        Map<String, Future<SearchResultsInternalDto>> listFuture = new HashMap<>();
        for (SearchClient client : clients) {
            listFuture.put(client.getName(), provider.executeSearch(client, searchTokens));
        }

        Map<String, SearchResultsInternalDto> results = new HashMap<>();
        for (Map.Entry<String, Future<SearchResultsInternalDto>> item: listFuture.entrySet()) {
            try {
                SearchResultsInternalDto dto = item.getValue().get();
                results.put(item.getKey(), dto);
            } catch(Exception e) {
                SearchResultsInternalDto dto = new SearchResultsInternalDto();
                dto.setErrorMessage(e.getMessage());
                results.put(item.getKey(), dto);
            }
        }
        return results;
    }
}
