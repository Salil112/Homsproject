package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Room;

public interface RoomService {
	Room insert(Room room);
	void delete(Long id);
	   Room update(Room room, Long id);
	   Room getOne(Long id);
	    List<Room> getAll();

}
