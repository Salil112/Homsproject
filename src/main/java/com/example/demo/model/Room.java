package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonFormat;


@EnableAutoConfiguration
@XmlRootElement
@Entity
@Table(name = "rooms")
public class Room {
	private Long roomid;
	private String checkindate;
	private String checkoutdate;
	private int price;
	private String roomtype;
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "room_id", unique = true, nullable = false)
	public Long getRoomid() {
		return roomid;
	}
	   
	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
	//@Temporal(TemporalType.DATE)
	@Column(name="check_in_date")
	public String getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}
	//@Temporal(TemporalType.DATE)
	@Column(name="check_out_date")
	public String getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	@Column(name="room_price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Column(name="room_type")
	public String getRoomtype() {
		return roomtype;
	}
	  @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "guest")
	    private Guest guest;
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	
	
	

}
