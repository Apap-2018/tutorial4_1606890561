package com.apap.tutorial4.model;

import java.sql.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class FlightModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//colom flightNumber
	@NotNull
	@Size(max = 50)
	@Column(name = "flight_Number", nullable = false)
	private String flightNumber;
	
//colom origin
	@NotNull
	@Size(max = 50)
	@Column(name = "origin", nullable = false)
	private String origin;
	
//colom destination
	@NotNull
	@Size(max = 50)
	@Column(name = "destination", nullable = false)
	private String destination;

//colom time
	@NotNull
	@Column(name = "time")
	private Date time;
	
//relasi n-1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pilot_licenseNumber", referencedColumnName = "license_number", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private PilotModel pilot;

//setter getter
	public String getFlightNumber() {
		return flightNumber;
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public PilotModel getPilot() {
		return pilot;
	}

	public void setPilot(PilotModel pilot) {
		this.pilot = pilot;
	}

}
