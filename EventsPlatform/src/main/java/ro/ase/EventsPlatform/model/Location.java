package ro.ase.EventsPlatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	
	@Column(name = "LATITUDE",nullable=false)
	private Double latitude;
	
	@Column(name = "LONGITUDE",nullable=false)
	private Double longitude;
	
	@Column(name = "CITY",nullable=false)
	private String city;
	
	@Column(name = "COUNTRY",nullable=false)
	private String country;
	
	@Column(name="ADDRESS",nullable=false)
	private String address;
	
	@Column(name="ZIPCODE",nullable=true)
	private String zipCode;

	public Location( String city, String country, String address) {
		super();
		this.latitude = 46.139839;
		this.longitude = 24.697160;
		this.city = city;
		this.country = country;
		this.address = address;
		this.zipCode ="030119";
	}

	public Location() {
		super();
	}

	public int getId() {
		return id;
	}

	public Location setId(int id) {
		this.id = id;
		return this;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Location setLatitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Location setLongitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Location setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Location setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Location setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Location setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}
	
	public Location build(){
		return this;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", city=" + city
				+ ", country=" + country + ", address=" + address + ", zipCode=" + zipCode + "]";
	}
	
	
	
	
	
	

}
