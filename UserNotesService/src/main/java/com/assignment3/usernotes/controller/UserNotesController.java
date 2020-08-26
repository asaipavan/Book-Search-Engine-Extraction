/**
 * 
 */
package com.assignment3.usernotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assignment3.usernotes.entities.KeyWordNotes;
import com.assignment3.usernotes.services.KeywordNotesServices;

/**
 * @author Sai Pavan
 *
 */
@RestController
@RequestMapping(value = "/api/notes")
public class UserNotesController {

	@Autowired
	KeywordNotesServices notesServices;

	@PostMapping(value = "/postnotes/{keyword}/{notes}")
	public String saveNotes(@PathVariable String keyword, @PathVariable String notes) {
		notesServices.saveToNotes(keyword, notes);
		return "Note Save successfully for the keyword: " + keyword;

	}

	@GetMapping(value = "/getnotes/{keyword}")
	public KeyWordNotes getNotes(@PathVariable String keyword) {

		KeyWordNotes retrievedNotes = null;
		retrievedNotes = notesServices.getNotes(keyword);
		return retrievedNotes;
	}

}
