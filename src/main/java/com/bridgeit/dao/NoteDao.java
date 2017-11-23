package com.bridgeit.dao;

import com.bridgeit.model.Note;

public interface NoteDao {
public void create(Note note);
public void update(Note note);
public Note read(Note note);
public void delete(Note note);
}
