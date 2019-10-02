package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.GuestService;
import com.example.demo.model.Guest;

@CrossOrigin
@RestController
@RequestMapping(value="/api/guest")
public class GuestController {
	private GuestService guestservice;

	public GuestController(GuestService guestservice) {
		super();
		this.guestservice = guestservice;
	}
	
	   @RequestMapping(value = "/", method = RequestMethod.POST)
	    public ResponseEntity<?> insert(@RequestBody Guest guest){

	        Guest guest1 = guestservice.insert(guest);
	        return new ResponseEntity<Guest>(guest1, HttpStatus.OK);
	    }
	   @PutMapping("/{id}")
	    public ResponseEntity<Guest> update(@PathVariable Long id,@RequestBody Guest guest) {
	        guestservice.update(guest, id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id){
	        guestservice.delete(id);
	        return new ResponseEntity<Guest>(HttpStatus.OK);
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Guest> getOne(@PathVariable Long id){
	        Guest g1 = guestservice.getOne(id);
	        return new ResponseEntity<Guest>(g1,HttpStatus.OK);

	    }
	    @GetMapping("/")
	    public ResponseEntity<List<Guest>> getAll(){

	        return new ResponseEntity<List<Guest>>(guestservice.getAll(),HttpStatus.OK);
	    }
	    
	

}
