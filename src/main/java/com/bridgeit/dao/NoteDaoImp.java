package com.bridgeit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgeit.model.Note;

@Component
public class NoteDaoImp implements NoteDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void create(Note note) {
		
		getSession().save(note);
	}


	@Override
	public void delete(Note note) {
		Query query=getSession().createQuery("delete Note where noteId='"+note.getNoteId()+"'");
		query.executeUpdate();		
	}

	
	
	@Override
	public void update(Note note) {
		getSession().merge(note);
		
	}

	@Override
	public Note read(Note note) {
		Query query=getSession().createQuery("from Note where noteId='"+note.getNoteId()+"'");
		Note note1=(Note) query.uniqueResult();
		return note1;
		
		// TODO Auto-generated method stub
		
	}

}
