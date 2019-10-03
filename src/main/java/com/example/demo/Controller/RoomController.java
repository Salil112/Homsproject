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

import com.example.demo.Service.RoomService;
import com.example.demo.model.Guest;
import com.example.demo.model.Room;

@CrossOrigin
@RestController
@RequestMapping(value="/api/room")
public class RoomController {
	private RoomService roomservice;

	public RoomController(RoomService roomservice) {
		super();
		this.roomservice = roomservice;
	}
	 @RequestMapping(value = "/", method = RequestMethod.POST)
	    public ResponseEntity<?> insert(@RequestBody Room room){

	        Room room1 = roomservice.insert(room);
	        return new ResponseEntity<Room>(room1, HttpStatus.OK);
	    }
	 @PutMapping("/{id}")
	    public ResponseEntity<Room> update(@PathVariable Long id,@RequestBody Room room) {
	        roomservice.update(room, id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	   @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id){
	        roomservice.delete(id);
	        return new ResponseEntity<Room>(HttpStatus.OK);
	    }
	   @GetMapping("/{id}")
	    public ResponseEntity<Room> getOne(@PathVariable Long id){
	        Room r1 = roomservice.getOne(id);
	        return new ResponseEntity<Room>(r1,HttpStatus.OK);

	    }
	   @GetMapping("/")
	    public ResponseEntity<List<Room>> getAll(){

	        return new ResponseEntity<List<Room>>(roomservice.getAll(),HttpStatus.OK);
	    }
	

}
