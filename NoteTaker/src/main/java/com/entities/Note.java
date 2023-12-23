package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {
	
	/*------------Data Member (Attribute)-----------*/
	@Id
	private int id;
	private String tittle;
	@Column(length=1500)
	private String content;
	private Date addeddate;

	/*----------------Generate getter & setter------------------*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddeddate() {
		return addeddate;
	}
	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
	
	
	/*--------------Generate Constructor --------------*/
	public Note(String tittle, String content, Date addeddate) {
		super();
		this.id = new Random().nextInt(100000);
		this.tittle = tittle;
		this.content = content;
		this.addeddate = addeddate;
	}
	
	/*-------------Generate Default Constructor-----------*/
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
   
}
