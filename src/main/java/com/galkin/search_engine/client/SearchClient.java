package com.galkin.search_engine.client;

import com.galkin.search_engine.dto.ResultItemInternalDto;

import java.util.List;

public interface SearchClient {

    String getName();
    List<ResultItemInternalDto> search(String word);
}
