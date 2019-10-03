package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@XmlRootElement
@Entity
@Table(name = "Guests")
public class Guest  {
	private Long id;
	private String first_name;
	private String last_name;
	private String address;
	private String id_type;
	private String phone_no;
	private String gender;
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "guest_id", unique = true, nullable = false)
	    public Long getId() {
	        return id;
	    }
	   @Column(name = "first_name")
	    public String getFirstName() {
	        return first_name;
	    }
	   @Column(name = "last_name")
	    public String getLastName() {
	        return last_name;
	    }
	   @Column(name = "address")
	    public String getAddress() {
	        return address;
	    }
	   @Column(name = "id_type")
	    public String getIdType() {
	        return id_type;
	    }
	   @Column(name = "Phone")
	    public String getPhone() {
	        return phone_no;
	    }
	   @Column(name = "gender")
	    public String getGender() {
	        return gender;
	    }
	   @OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "room_id", nullable = false)
	    private Room room;
	   public void setId(Long id) {
	        this.id=id;
	    }
	   
	    public void setFirstName(String first_name) {
	        this.first_name=first_name;
	    }
	   
	    public void setLastName(String last_name) {
	        this.last_name = last_name;
	    }
	   
	    public void setAddress(String address) {
	        this.address=address;
	    }
	   
	    public void setIdType(String id_type) {
	        this.id_type=id_type;
	    }
	   
	    public void setPhone(String phone_no) {
	        this.phone_no=phone_no;
	    }
	  
	    public void setGender(String gender) {
	        this.gender=gender;
	    }
		@Override
		public String toString() {
			return "Guest [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address="
					+ address + ", id_type=" + id_type + ", phone_no=" + phone_no + ", gender=" + gender + "]";
		}
	    
	
	

}
