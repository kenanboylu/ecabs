package com.ecabs.booking.model;

import java.io.Serializable;

public class TripWaypoint implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1356128126910198299L;
	private Long id;
	private String locality;
	private Long latitude;
	private Long longitude;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
}
