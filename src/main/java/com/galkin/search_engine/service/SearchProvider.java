package com.galkin.search_engine.service;

import com.galkin.search_engine.dto.SearchResultsInternalDto;

import java.util.List;
import java.util.Map;

public interface SearchProvider {
    Map<String, SearchResultsInternalDto> searchByToken(List<String> searchTokens);
}
