/**
 * 
 */
package com.assignment3.searchlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.assignment3.searchlog.services.SearchLogServices;

/**
 * @author Sai Pavan Akuralapu
 *
 */
@RestController
@RequestMapping(value = "/api/")
public class SearchLogController {

	@Autowired
	SearchLogServices searchLogServices;

	@PostMapping(value = "/saveupdatelog/{keyword}")
	public String searchKeyword(@PathVariable("keyword") String keyword) {

		searchLogServices.saveOrUpdateSearchLog(keyword);
		return "Saved";

	}

}
