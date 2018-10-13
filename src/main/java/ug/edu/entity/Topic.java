package ug.edu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id; 
	
	@Column(name = "topic_name")
	private String topic_name;
	
	@Column(name = "topic_text")
	private String topic_text;
	
	@Column(name = "date")
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JoinColumn(name = "topics_id")
	private List<Message> messages;
	
	
	public Topic() {
		date = new Date();
		// TODO
		topic_name = "aaa";
		topic_text = "aaa";
		
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTopic_name() {
		return topic_name;
	}


	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}


	public String getTopic_text() {
		return topic_text;
	}


	public void setTopic_text(String topic_text) {
		this.topic_text = topic_text;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	public void addMessage(Message message) {
		if (messages == null) {
			messages = new ArrayList<>();
		}
		
		messages.add(message);
	}
	

	@Override
	public String toString() {
		return "Thopic [id=" + id + ", topic_name=" + topic_name + ", topic_text=" + topic_text + "]";
	}
	
}
