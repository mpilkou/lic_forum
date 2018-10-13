package ug.edu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "text", length = 100)
	private String text;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "topics_id")
	private long topics_id;
	
	public Message() {
		date = new Date();
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getTopics_id() {
		return topics_id;
	}


	public void setTopics_id(long topics_id) {
		this.topics_id = topics_id;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", date=" + date + "]";
	}
	
}
