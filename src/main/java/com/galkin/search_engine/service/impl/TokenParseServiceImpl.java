package com.galkin.search_engine.service.impl;

import com.galkin.search_engine.exception.ParseException;
import com.galkin.search_engine.service.TokenParseService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TokenParseServiceImpl implements TokenParseService {

    @Override
    public List<String> parse(InputStream inputStream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            List<String> tokens = new ArrayList<>();
            br.lines().forEach(line -> tokens.addAll(Arrays.asList(line.replaceAll("[\\s]{2,}", " ").split(" "))));
            return tokens;
        } catch(Exception e) {
            throw new ParseException(e.getMessage(), e);
        }
    }
}
