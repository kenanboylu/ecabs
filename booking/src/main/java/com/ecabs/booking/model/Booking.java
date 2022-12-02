package com.ecabs.booking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "booking")
@ApiModel(value = "booking model documentation", description = "Model")
public class Booking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5297350235465961496L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String passengerName;
	@Column
	private String contractNumber;
	@Column
	private Date pickupTime;
	@Column
    private String asap;
	@Column
	private Date waittingTime;
	@Column
	private Integer numberOfPassengers;
	@Column
	private BigDecimal price;
	@Column
	private Date createdOn;
	@Column
	private Date modifiedOn;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "booking_id")
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