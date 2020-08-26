/**
 * 
 */
package com.assignment3.catalogue.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment3.catalogue.entities.TitleAndAuthor;
import com.assignment3.catalogue.repositories.TitleAndAuthorRepository;

/**
 * @author Sai Pavan Akuralapu
 *
 */
@Service("CatalougueServices")
public class CatalogueServices {

	@Value("${searchlog.api.url}")
	String loguri;

	@Autowired
	TitleAndAuthorRepository repository;

	private static Map<String, String> catalogue = new TreeMap<String, String>();

	/**
	 * 
	 */
	public CatalogueServices() {
		// database = dbConnectivity.ConnectToMongoDB();
		// TODO Auto-generated constructor stub

	}

	public List<TitleAndAuthor> retrieveDetailsfromKeyword(String keyword) {
		System.out.println(keyword);
		List<TitleAndAuthor> listOfTitleandAuthor = new ArrayList<TitleAndAuthor>();
		String keyword1 = ".*" + keyword + ".*";
		listOfTitleandAuthor = repository.findByTitlesOrAuthorLike(keyword1, keyword1);
		repository.findAll();
		if (!listOfTitleandAuthor.isEmpty()) {
			for (TitleAndAuthor d : listOfTitleandAuthor) {

				catalogue.put(d.getTitle(), d.getAuthor());
			}

		}
		System.out.println(keyword);
		String uri = loguri + "{keyword}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("keyword", keyword);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, null, String.class, params);
		return listOfTitleandAuthor;
	}

	public Map<String, String> getcatalogue() {
		return catalogue;
	}
}
