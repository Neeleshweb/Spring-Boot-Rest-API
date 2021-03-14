package com.reswebservice.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reswebservice.application.model.Userdetails;
import com.reswebservice.application.repo.Userdetailsrepo;

@Service
public class Userdetailsservice {

	@Autowired
	private Userdetailsrepo userdetailsrepo;
	
	public Userdetails savedetails(Userdetails details) {
		return userdetailsrepo.save(details);
	}
	public List<Userdetails> savemultipleusers(List<Userdetails> details) {
		return userdetailsrepo.saveAll(details);
	}
	public List<Userdetails> getallusers(){
		
		return userdetailsrepo.findAll();
	}
	public Userdetails getsingleuserbyid(String emailid) {
		return userdetailsrepo.findById(emailid).orElse(null);
	}
	public Userdetails getsingleuserbyfirstname(String firstname) {
		return userdetailsrepo.findByFirstname(firstname);
	}
	public String removeuserdetails(String emailid) {
		userdetailsrepo.deleteById(emailid); 
		return "User removed"+emailid;
		}
	
	public Userdetails updatedetails(Userdetails detailstobereplacedwithexisting) {
		Userdetails existingdetails=userdetailsrepo.findById(detailstobereplacedwithexisting.getEmailid()).orElse(null);
		existingdetails.setFirstname(detailstobereplacedwithexisting.getFirstname());
		existingdetails.setLastname(detailstobereplacedwithexisting.getLastname());
		existingdetails.setAddress(detailstobereplacedwithexisting.getAddress());
		existingdetails.setMobileno(detailstobereplacedwithexisting.getMobileno());
		existingdetails.setPassword(detailstobereplacedwithexisting.getPassword());
		return userdetailsrepo.save(existingdetails);
	}
	
	
}

