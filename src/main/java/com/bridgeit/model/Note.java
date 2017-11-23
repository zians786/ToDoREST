package com.bridgeit.model;

import java.sql.Date;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;


@Entity
@Table(name="Note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer noteId;
	
	private String title;
	
	private String description;
	
	private Date createdDate;

	private Date modifiedDate;

	@ManyToOne()
    @JoinColumn(name = "userId")
	private User user;

	
//	private boolean isArchived=false;;
//
//	// initially, note must be not in trash
//	// so keep this true initially
//	private boolean inTrash = false;
//
//	private String color =null;
//
//	private boolean isPinned=false;

	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//
//	public boolean isArchived() {
//		return isArchived;
//	}
//
//	public void setArchived(boolean isArchived) {
//		this.isArchived = isArchived;
//	}
//
//	public boolean isInTrash() {
//		return inTrash;
//	}
//
//	public void setInTrash(boolean inTrash) {
//		this.inTrash = inTrash;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public boolean isPinned() {
//		return isPinned;
//	}
//
//	public void setPinned(boolean isPinned) {
//		this.isPinned = isPinned;
//	}
//

	// @JsonIgnore is required so as to prevent Jackson fasterxml databind to go
	// into loop
	// if not mentioned, program goes into infinite loop and results into stack
	// overflow

//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "userid")
//	private User user = new User();
//
//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@ManyToMany
//	@JoinTable(name = "collabUsers", joinColumns = @JoinColumn(name = "noteid"), inverseJoinColumns = @JoinColumn(name = "userid"))
//	private Set<User> collabUsers = new HashSet<>();


	
	
}
