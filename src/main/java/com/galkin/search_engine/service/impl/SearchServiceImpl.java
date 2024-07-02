package com.galkin.search_engine.service.impl;

import com.galkin.search_engine.dto.SearchResultsInternalDto;
import com.galkin.search_engine.dto.SearchResultsDto;
import com.galkin.search_engine.service.SearchProvider;
import com.galkin.search_engine.service.SearchService;
import com.galkin.search_engine.service.TokenParseService;
import com.galkin.search_engine.mapper.SearchMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
    public static final String ERROR_MESSAGE = "Search engine %s return error. ";
    private TokenParseService tokenParseService;
    private SearchProvider searchProvider;
    private SearchMapper mapper;

    @Override
    public SearchResultsDto search(InputStream inputStream) {
        List<String> searchTokens = tokenParseService.parse(inputStream);
        Map<String, SearchResultsInternalDto> results = searchProvider.searchByToken(searchTokens);
        SearchResultsDto searchResultsDto = new SearchResultsDto();
        searchResultsDto.setList(new ArrayList<>());
        searchResultsDto.setWarning("");
        for (String searchEngine: results.keySet()) {
            if (results.get(searchEngine).getErrorMessage() != null) {
                searchResultsDto.setWarning(searchResultsDto.getWarning() + String.format(ERROR_MESSAGE, searchEngine));
            } else {
                searchResultsDto.getList().addAll(mapper.convertInternalListDtoToResponseListDto(results.get(searchEngine).getList()));
            }
        }
        return searchResultsDto;
    }
}
