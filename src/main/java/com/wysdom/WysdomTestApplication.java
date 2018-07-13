package com.wysdom;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.wysdom.model.WikipediaInfo;
import com.wysdom.service.WysdomAIService;
import com.wysdom.service.WysdomAIServiceImpl;

@SpringBootApplication
public class WysdomTestApplication {
	private static final Logger LOGGER = LogManager.getLogger(WysdomTestApplication.class);
	static ExecutorService SEARCH_EXECUTOR = Executors.newCachedThreadPool();

	public static void main(String[] args) {
		LOGGER.info("main function starting work:");
		WysdomAIService wysdomAIService = new WysdomAIServiceImpl();

		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {

				String searchKey = args[i];
				Runnable searchWikipedia = () -> {
					try {
						List<WikipediaInfo> resultInfoList = wysdomAIService.findInfoFromWikipedia(searchKey);
						for (int j = 0; j < resultInfoList.size(); j++) {
							LOGGER.info(resultInfoList.get(j).getTitle() + "||" + resultInfoList.get(j).getUrl());
						}

					} catch (Exception e) {
						LOGGER.error("Error happened in search:", e);
					}

				};

				// Submitting this Runnable class to the executor
				SEARCH_EXECUTOR.submit(searchWikipedia);
			}
			SEARCH_EXECUTOR.shutdown();

		}

		SpringApplication.run(WysdomTestApplication.class, args);

	}

}
