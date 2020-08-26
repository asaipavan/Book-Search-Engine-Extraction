/**
 * 
 */
package com.assignment3.catalogue.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment3.catalogue.entities.TitleAndAuthor;
import com.assignment3.catalogue.services.CatalogueServices;

/**
 * @author Sai Pavan
 *
 */
@RestController
@RequestMapping(value = "/api/")
public class CatalogueController {

	@Autowired
	CatalogueServices catalogueServices;

	@GetMapping(value = "/search/{keyword}")
	public List<TitleAndAuthor> searchKeyword(HttpServletRequest request, @PathVariable("keyword") String keyword) {

		List<TitleAndAuthor> retrievedDetails = new ArrayList<TitleAndAuthor>();
		retrievedDetails = catalogueServices.retrieveDetailsfromKeyword(keyword);

		return retrievedDetails;
	}

	@GetMapping(value = "/getCatalogue")
	public Map<String, String> getcatalogue() {

		return catalogueServices.getcatalogue();
	}

}
