package com.galkin.search_engine.service;

import com.galkin.search_engine.client.SearchClient;
import com.galkin.search_engine.dto.SearchResultsInternalDto;

import java.util.List;
import java.util.concurrent.Future;

public interface SearchClientProvider {
    Future<SearchResultsInternalDto> executeSearch(SearchClient client, List<String> searchTokens);
}
