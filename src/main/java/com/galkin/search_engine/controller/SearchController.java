package com.galkin.search_engine.controller;

import com.galkin.search_engine.dto.SearchResultsDto;
import com.galkin.search_engine.exception.SearchException;
import com.galkin.search_engine.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class SearchController {

    private SearchService searchService;

    @PostMapping("/search")
    public ResponseEntity<SearchResultsDto> searchByFileToken(@RequestParam("file") MultipartFile file) {
        try {
            return new ResponseEntity<>(searchService.search(file.getInputStream()), HttpStatus.OK);
        } catch(Exception ex) {
            throw new SearchException(ex.getMessage(), ex);
        }
    }
}
