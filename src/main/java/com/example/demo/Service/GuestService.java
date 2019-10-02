package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Guest;

public interface GuestService {
	Guest insert(Guest guest);
	void delete(Long id);
	   Guest update(Guest guest, Long id);
	   Guest getOne(Long id);
	    List<Guest> getAll();
	}
