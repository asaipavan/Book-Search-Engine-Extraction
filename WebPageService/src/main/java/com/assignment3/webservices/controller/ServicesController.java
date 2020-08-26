/**
 * 
 */
package com.assignment3.webservices.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import com.assignment3.webservices.entities.KeyWordNotes;
import com.assignment3.webservices.entities.TitleAndAuthor;

/**
 * @author Sai Pavan Akuralapu
 *
 */
@Controller
public class ServicesController {

	@Value("${notes.api.url}")
	String notesuri;

	@Value("${search.api.url}")
	String searchuri;

	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		// model.put("message", this.message);
		request.setAttribute("detailsavailable", false);
		request.setAttribute("error", "");
		request.setAttribute("desc", "");
		//System.out.println("here");
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public String search(String keyword, Model model, HttpServletRequest request) {

		// System.out.println(keyword);
		if (keyword != null && !keyword.isEmpty()) {
			String uri = searchuri + "{keyword}";

			Map<String, String> params = new HashMap<String, String>();
			params.put("keyword", keyword);
			RestTemplate restTemplate = new RestTemplate();
			TitleAndAuthor[] collection = restTemplate.getForObject(uri, TitleAndAuthor[].class, params);

			HttpSession session = request.getSession();
			request.setAttribute("detailsavailable", true);
			request.setAttribute("desc", "Keyword Searched: " + keyword);
			session.setAttribute("details", collection);
			request.setAttribute("error", "");
			request.setAttribute("noteserror", "");
			request.setAttribute("notesdetailsavailable", false);
			session.setAttribute("keyword", keyword);
		} else {
			request.setAttribute("detailsavailable", false);
			request.setAttribute("desc", "");
			request.setAttribute("error", "Please enter the keyword");
			request.setAttribute("notesdetailsavailable", false);
		}

		return "home";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/postnotes")
	public String postNotes(String notes, String keyword, HttpServletRequest request) {

		if (notes != null && !notes.isEmpty()) {
			String uri = notesuri + "postnotes/{keyword}/{notes}";
			Map<String, String> params = new HashMap<String, String>();
			params.put("keyword", keyword);
			params.put("notes", notes);
			RestTemplate restTemplate = new RestTemplate();
			String response = restTemplate.postForObject(uri, null, String.class, params);
			request.setAttribute("detailsavailable", true);
			request.setAttribute("noteserror", response);
		} else {
			request.setAttribute("detailsavailable", true);
			request.setAttribute("noteserror", "Please enter the notes");
		}

		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getnotes")
	public String getNotes(String keyword, HttpServletRequest request) {

		String uri = notesuri + "getnotes/{keyword}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("keyword", keyword);
		RestTemplate restTemplate = new RestTemplate();
		KeyWordNotes response = restTemplate.getForObject(uri, KeyWordNotes.class, params);
		HttpSession session = request.getSession();
		if (response != null) {
			request.setAttribute("noteserror", "");
			request.setAttribute("detailsavailable", true);
			request.setAttribute("notesdetailsavailable", true);
			session.setAttribute("notesdetails", response);
			request.setAttribute("notesreturnmessage",
					response.getNotes().size() + " notes retrieved for the provided keyword");
		} else {
			request.setAttribute("noteserror", "");
			request.setAttribute("detailsavailable", true);
			request.setAttribute("notesdetailsavailable", false);
			request.setAttribute("notesreturnmessage", "No notes available for the provided keyword");
		}

		return "home";
	}

}
