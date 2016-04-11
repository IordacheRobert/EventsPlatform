package ro.ase.EventsPlatform.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Ticket {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "EVENT_ID")
	private Event event;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int id, User user, Event event) {
		super();
		this.id = id;
		this.user = user;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public Ticket setId(int id) {
		this.id = id;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Ticket setUser(User user) {
		this.user = user;
		return this;
	}

	public Event getEvent() {
		return event;
	}

	public Ticket setEvent(Event event) {
		this.event = event;
		return this;
	}
	
	public Ticket build(){
		return this;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", user=" + user + ", event=" + event + "]";
	}
	

	
	
	
}
