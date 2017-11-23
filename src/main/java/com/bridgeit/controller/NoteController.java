package com.bridgeit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.model.Note;
import com.bridgeit.model.User;
import com.bridgeit.service.NoteService;
import com.bridgeit.service.Service;

@RestController
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	
	@RequestMapping(value = "notes/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Note note,HttpServletRequest request) {
		
		String token=request.getHeader("accToken");
		String message=noteService.createNote(note,token);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "notes/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestBody Note note,HttpServletRequest request) {
		
		String token=request.getHeader("accToken");
		String message=noteService.deleteNote(note,token);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}

	@RequestMapping(value = "notes/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody Note note,HttpServletRequest request) {

		String token=request.getHeader("accToken");
		String message=noteService.updateNote(note,token);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}

	@RequestMapping(value = "notes/read", method = RequestMethod.POST)
	public ResponseEntity<Note> read(@RequestBody Note note,HttpServletRequest request) {

		String token=request.getHeader("accToken");
		Note resultNote=noteService.readNote(note, token);
		return new ResponseEntity<Note>(resultNote, HttpStatus.OK);

	}
	
	

}
