package com.wysdom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wysdom.model.WikipediaInfo;
import com.wysdom.service.WysdomAIService;

@RestController
@RequestMapping("/rest/v1")
public class WysdomTestController {
	private static final Logger LOGGER = LogManager.getLogger(WysdomTestController.class);

	@Autowired
	WysdomAIService wysdomAIService;

	@RequestMapping(path = "/searchWikipedia/{allSearchKey}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> search(@PathVariable("allSearchKey") String allSearchKey) {
		LOGGER.info("WysdomTestController starting search->Begin");
		
		List<WikipediaInfo> searchWikipediaList = new ArrayList<WikipediaInfo>();

		String[] keyParam = allSearchKey.split("\\*");
		if (keyParam != null && keyParam.length > 0) {
			for (int i = 0; i < keyParam.length; i++) {

				String searchKey = keyParam[i];
				 try {
						List<WikipediaInfo> resultInfoList = wysdomAIService.findInfoFromWikipedia(searchKey);
						searchWikipediaList.addAll(resultInfoList);

					} catch (Exception e) {
						LOGGER.error("Error happened in single search:", e);
					}
				
			}
			
		}
		
		LOGGER.info("WysdomTestController starting search->End");
		if (searchWikipediaList.isEmpty()) {
			return new ResponseEntity<List<WikipediaInfo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WikipediaInfo>>(searchWikipediaList, HttpStatus.OK);

	}
}
