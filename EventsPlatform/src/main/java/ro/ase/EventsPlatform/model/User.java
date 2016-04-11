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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME",nullable=false)
	private String lastName;
	
	@Column(name="EMAIL",nullable=false)
	private String email;
	
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@Column(name="AVATAR_URL",nullable=false)
	private String avatarURL;
	
	@Column(name="TYPE",nullable=false)
	private int type;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;
	
	@OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Event> myEvents=new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "participants",cascade=CascadeType.ALL)
	private List<Event> attendingEvents = new ArrayList<>();
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.avatarURL =  "someCoverURL";
		this.type = 1;
		this.location = new Location("Bucharest","Romania","unknow");
		this.firstName =email;
		this.lastName = email;
	}

	public User() {
		super();
	}
	
	

	public List<Event> getMyEvents() {
		return myEvents;
	}

	public void setMyEvents(List<Event> myEvents) {
		this.myEvents = myEvents;
	}

	public List<Event> getAttendingEvents() {
		return attendingEvents;
	}

	public void setAttendingEvents(List<Event> attendingEvents) {
		this.attendingEvents = attendingEvents;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
		return this;
	}

	public User setType(int type) {
		this.type = type;
		return this;
	}

	public User setLocation(Location location) {
		this.location = location;
		return this;
	}


	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public int getType() {
		return type;
	}

	public Location getLocation() {
		return location;
	}

	public User build(){
		return this;
	}


	

	
}
