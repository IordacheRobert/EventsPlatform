package ro.ase.EventsPlatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "REPORT")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	
	@Column(name = "TITLE", nullable = false)
	private String title;
	
	@Column(name = "CONTENT", nullable = false)
	private String content;
	
	@Column(name = "DATE", nullable = false)
	private Date date;

	
	@ManyToOne
	private Event event;
	
	@ManyToOne
	private User user;
	
}
