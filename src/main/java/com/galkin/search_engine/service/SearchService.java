package com.galkin.search_engine.service;

import com.galkin.search_engine.dto.SearchResultsDto;

import java.io.InputStream;

public interface SearchService {
    SearchResultsDto search(InputStream inputStream);
}
