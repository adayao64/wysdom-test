package com.wysdom.service;

import java.util.List;

import com.wysdom.model.WikipediaInfo;

public interface WysdomAIService {

	List<WikipediaInfo> findInfoFromWikipedia(String key) throws Exception;
}
