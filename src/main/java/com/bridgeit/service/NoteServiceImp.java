package com.bridgeit.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.dao.NoteDao;
import com.bridgeit.model.Note;
import com.bridgeit.model.User;
import com.bridgeit.utility.JWT;

@Component
@Transactional
public class NoteServiceImp implements NoteService {

	@Autowired
	NoteDao noteDao;

	@Autowired
	JWT jwtObject;

	@Override
	public String createNote(Note note, String token) {
		String status = jwtObject.jwtVerify(token);
		if (status != null) {
			int userId = Integer.parseInt(status);
			User user = new User();
			user.setUserId(userId);
			note.setUser(user);
			note.setCreatedDate(new Date(System.currentTimeMillis()));
			note.setModifiedDate(new Date(System.currentTimeMillis()));
			noteDao.create(note);

			return "Note Successfully Created.";
		} else {
			return "Invalid Token,Please login Again.";
		}

	}

	@Override
	public String deleteNote(Note note, String token) {
		String status = jwtObject.jwtVerify(token);
		if (status != null) {
			noteDao.delete(note);
			
			return "Note Deleted Successfully.";
		} else {
			return "Invalid Token,Please login Again.";
		}

	}
	
	public String updateNote(Note note,String token) {
		String status = jwtObject.jwtVerify(token);
		if (status != null) {
			int userId = Integer.parseInt(status);
			User user = new User();
			user.setUserId(userId);
			note.setUser(user);
			note.setModifiedDate(new Date(System.currentTimeMillis()));
			noteDao.update(note);
			
			return "Note Updated Successfully.";
		} else {
			return "Invalid Token,Please login Again.";
		}

	}
	

	@Override
	public Note readNote(Note note,String token) {
		Note resultNote=null;
		String status = jwtObject.jwtVerify(token);
		if (status != null) {
			 resultNote=noteDao.read(note);
				return resultNote;
		} else {
			return resultNote;
		}

	}

	

}
