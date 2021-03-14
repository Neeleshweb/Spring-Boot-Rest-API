package com.reswebservice.application.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reswebservice.application.service.Userdetailsservice;
import com.reswebservice.application.Exceptionclasses.UserNotFoundException;
import com.reswebservice.application.model.Userdetails;

@RestController
public class UserdetailsController {
	@Autowired
	private Userdetailsservice service;

	@PostMapping("/createuser")
	public Userdetails createuser(@RequestBody Userdetails details) {
		return service.savedetails(details);
	}
	@PostMapping("/createmultipleusers")
	public List<Userdetails> createmultipleusers(@RequestBody List<Userdetails> details) {
		return service.savemultipleusers(details);
	}
	@GetMapping("/getallusers")
	public List<Userdetails> getalltheusers() {
		return service.getallusers();
	}
	@GetMapping("/userbyemail/{emailid}")
	public EntityModel<Userdetails> getuserbyemail( @PathVariable String emailid) {
		
		 Userdetails user=service.getsingleuserbyid(emailid);
		 if(user==null) {
			 throw new UserNotFoundException("emailid"+emailid);
		 }
		 EntityModel<Userdetails> model=new EntityModel<Userdetails>(user);
		 WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getalltheusers());
		 model.add(link.withRel("This is the link to get details for all the users"));
		 return model;
	}
	@GetMapping("/userbyname/{firstname}")
	public Userdetails getuserbyname(@PathVariable String firstname) {
		return service.getsingleuserbyfirstname(firstname);
	}
	@PutMapping("/updatedetails")
	public Userdetails updateuser(@RequestBody Userdetails details) {
		return service.updatedetails(details);
	}
	@DeleteMapping("/deleteuser/{emailid}")
	public String removeuser(@PathVariable String emailid) {
		return service.removeuserdetails(emailid);
	}
	
}
