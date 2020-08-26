package com.assignment3.usernotes.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.assignment3.usernotes.entities.KeyWordNotes;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("KeywordNotesServices")
public class KeywordNotesServices {

	private static ArrayList<KeyWordNotes> notesList = new ArrayList<KeyWordNotes>();

	public void saveToNotes(String keyword, String note) {
		if (!notesList.isEmpty()) {
			if (notesList.contains(new KeyWordNotes(keyword.toUpperCase()))) {
				int i = notesList.indexOf(new KeyWordNotes(keyword));
				KeyWordNotes keyNotes = notesList.get(i);
				keyNotes.getNotes().add(note);
			} else {
				ArrayList<String> notes = new ArrayList<String>();
				notes.add(note);
				KeyWordNotes keyNotes = new KeyWordNotes(keyword.toUpperCase(), notes);
				notesList.add(keyNotes);
			}
		} else {
			ArrayList<String> notes = new ArrayList<String>();
			notes.add(note);
			KeyWordNotes keyNotes = new KeyWordNotes(keyword.toUpperCase(), notes);
			notesList.add(keyNotes);
		}
		saveNotesinFile();

	}

	public KeyWordNotes getNotes(String keyword) {
		KeyWordNotes keyWordNotes = null;
		if (!notesList.isEmpty()) {
			if (notesList.contains(new KeyWordNotes(keyword))) {
				int i = notesList.indexOf(new KeyWordNotes(keyword));
				keyWordNotes = notesList.get(i);
			}
		}
		return keyWordNotes;

	}
	
	public void saveNotesinFile()
	{
		try {
			File jsonInputFile = new File("usernotes.json");
			FileWriter writer = new FileWriter(jsonInputFile, false);
			ObjectMapper mapper = new ObjectMapper();
			for(KeyWordNotes note: notesList)
			{
				String jsonString = mapper.writeValueAsString(note);
				writer.append(jsonString);
			}
			writer.flush();
			writer.close();
			//System.out.println(jsonString);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
