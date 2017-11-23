package com.bridgeit.service;

import com.bridgeit.model.Note;

public interface NoteService {


		String createNote(Note note,String token);
		Note readNote(Note note,String token);
		String updateNote(Note note,String token);
		String deleteNote(Note note,String token);
	}


