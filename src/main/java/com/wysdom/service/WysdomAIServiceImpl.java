package com.wysdom.service;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import com.wysdom.model.WikipediaInfo;

@Service("wysdomAIService")
public class WysdomAIServiceImpl implements WysdomAIService {

	@Override
	public List<WikipediaInfo> findInfoFromWikipedia(String key) throws Exception {
		List<WikipediaInfo> wikipediaInfo = new ArrayList<>();
		//https://en.wikipedia.org/w/index.php?search=world+cup&title=Special%3ASearch&profile=default&fulltext=1
		String queueEndpoint = "https://en.wikipedia.org/w/index.php?search=";
		StringBuilder builder = new StringBuilder(queueEndpoint);
		builder.append(key + "&title=Special%3ASearch&profile=default&fulltext=1");
		String hrefPrefix = "https://en.wikipedia.org";
		
		Document doc = Jsoup.connect(builder.toString()).get();
		Elements data = null;
		
		data = doc.select("div[class='mw-search-result-heading']");
		
		//it only returns 3 results based on requirement, it can be extensible to return all search results
		if(data != null && data.size() > 0){
			wikipediaInfo.add(0, new WikipediaInfo(data.get(0).select("a[href][title]").attr("title")
					,hrefPrefix+data.get(0).select("a[href][title]").attr("href")));
			wikipediaInfo.add(1, new WikipediaInfo(data.get(1).select("a[href][title]").attr("title")
					,hrefPrefix+data.get(1).select("a[href][title]").attr("href")));
			wikipediaInfo.add(2, new WikipediaInfo(data.get(2).select("a[href][title]").attr("title")
					,hrefPrefix+data.get(2).select("a[href][title]").attr("href")));
			
		}
		return wikipediaInfo;
	}
}
