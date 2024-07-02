package com.galkin.search_engine.service;

import java.io.InputStream;
import java.util.List;

public interface TokenParseService {
    List<String> parse(InputStream inputStream);
}
