package com.reswebservice.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="User_details")
public class Userdetails {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String emailid;
	@JsonIgnore
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String mobileno;
	protected Userdetails() {
		
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailid() {
		return emailid;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public Userdetails(String password, String firstname, String lastname, String address, String mobileno) {
		super();
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "Userdetails [emailid=" + emailid + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", address=" + address + ", mobileno=" + mobileno + "]";
	}
	
}

