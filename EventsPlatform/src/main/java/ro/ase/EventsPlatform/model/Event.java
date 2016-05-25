package ro.ase.EventsPlatform.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "EVENT")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "DESCRIPTION", nullable = false, length = 1000)
	private String description;

	@Column(name = "STATE", nullable = false)
	private Boolean state;

	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@Column(name = "DEADLINE", nullable = false)
	private Date deadline;

	@Column(name = "AVAILABLE_TICKETS", nullable = false)
	private int availableTickets;

	@Column(name = "COVER_URL", nullable = false)
	private String coverURL;

	@Column(name = "PRICE", nullable = false)
	private Double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORGANIZER_ID", nullable = false)
	@JsonIgnore
	private User organizer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "EVENT_TYPE_ID")
	private EventType type;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<User> participants = new ArrayList<>();

	
	
	@OneToMany(mappedBy="event")
	private List<Comment> comments=new ArrayList();
	
	@OneToMany(mappedBy="event")
	private List<Report> reports=new ArrayList();
	
	
	public Event() {
		super();
	}

	public Event(String title, String description, Date startDate, Date endDate, Date deadline, Double price,
			User organizer, EventType type, Location location) {
		super();
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
		this.price = price;
		this.organizer = organizer;
		this.type = type;
		
		this.location = new Location("Bucharest", "Romania", "unknow");
		this.availableTickets = 1000;
		this.coverURL = "someCoverURL";
		this.state = false;
	}

	public void addParticipant(User participant) {
		this.participants.add(participant);
		participant.getMyEvents().add(this);
	}

	public void removeParticipant(User participant) {
		this.participants.remove(participant);
		participant.getMyEvents().remove(this);
	}

	public Event setId(int id) {
		this.id = id;
		return this;
	}

	public Boolean getIsActive() {
		return state;
	}

	public void setIsActive(Boolean isActive) {
		this.state = isActive;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	public Event setTitle(String title) {
		this.title = title;
		return this;
	}

	public Event setDescription(String description) {
		this.description = description;
		return this;
	}

	public Event setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public Event setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	public Event setDeadline(Date deadline) {
		this.deadline = deadline;
		return this;
	}

	public Event setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
		return this;
	}

	public Event setCoverURL(String coverURL) {
		this.coverURL = coverURL;
		return this;
	}

	public Event setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Event setOrganizer(User organizer) {
		this.organizer = organizer;
		return this;
	}

	public Event setType(EventType type) {
		this.type = type;
		return this;
	}

	public Event setLocation(Location location) {
		this.location = location;
		return this;
	}

	public Event build() {
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

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public String getCoverURL() {
		return coverURL;
	}

	public Double getPrice() {
		return price;
	}

	public User getOrganizer() {
		return organizer;
	}

	public EventType getType() {
		return type;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", isActive=" + state
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", deadline=" + deadline + ", availableTickets="
				+ availableTickets + ", coverURL=" + coverURL + ", price=" + price + ", organizer=" + organizer
				+ ", type=" + type + ", location=" + location + ", participants=" + participants + "]";
	}

}
