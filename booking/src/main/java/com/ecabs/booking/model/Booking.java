package com.ecabs.booking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Booking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5297350235465961496L;

	private Long id;
	private String passengerName;
	private String contractNumber;
	private Date pickupTime;
    private String asap;
	private Date waittingTime;
	private Integer numberOfPassengers;
	private BigDecimal price;
	private Date createdOn;
	private Date modifiedOn;
	private List<TripWaypoint> tripWaypoint;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	public String getAsap() {
		return asap;
	}
	public void setAsap(String asap) {
		this.asap = asap;
	}
	public Date getWaittingTime() {
		return waittingTime;
	}
	public void setWaittingTime(Date waittingTime) {
		this.waittingTime = waittingTime;
	}
	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public List<TripWaypoint> getTripWaypoint() {
		return tripWaypoint;
	}
	public void setTripWaypoint(List<TripWaypoint> tripWaypoint) {
		this.tripWaypoint = tripWaypoint;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override 
	public String toString()
    {
        // Returning attributes of booking
        return "Booking [id="
            + id
            + ", passengerName=" + passengerName
            + ", contractNumber=" + contractNumber 
        	+ ", pickupTime=" + pickupTime
            + ", asap=" + asap
        	+ ", waittingTime=" + waittingTime
        	+ ", numberOfPassengers=" + numberOfPassengers
        	+ ", price=" + price
        	+ ", createdOn=" + createdOn
        	+ ", modifiedOn=" + modifiedOn
            + "]";
    }
	
	
}
