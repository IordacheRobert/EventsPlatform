package ro.ase.EventsPlatform.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="EVENT_TYPE")
public class EventType {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE",nullable=false)
	private String title;
	
	@Column(name = "DESCRIPTION",nullable=false,length=1000)
	private String description;
	
	@OneToMany(mappedBy = "organizer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Event> events=new ArrayList<>();

	public EventType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventType( String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public EventType setId(int id) {
		this.id = id;
		return this;
	}

	public EventType setTitle(String title) {
		this.title = title;
		return this;
	}

	public EventType setDescription(String description) {
		this.description = description;
		return this;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public EventType build(){
		return this;
	}

	@Override
	public String toString() {
		return "EventType [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
}
