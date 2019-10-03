package com.example.demo.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Service.RoomService;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	private RoomRepository roomrepository;
	

	public RoomServiceImpl(RoomRepository roomrepository) {
		super();
		this.roomrepository = roomrepository;
	}

	@Override
	public Room insert(Room room) {
		// TODO Auto-generated method stub
		Room room1=roomrepository.save(room);
		return room1;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		roomrepository.deleteById(id);
	}

	@Override
	public Room update(Room room, Long id) {
		// TODO Auto-generated method stub
		Optional<Room> r1=roomrepository.findById(id);
		if(r1.isPresent()) {
			Room r2=r1.get();
			/*
			 * g2.setFirstName(guest.getFirstName()); g2.setLastName(guest.getLastName());
			 * g2.setAddress(guest.getAddress()); g2.setGender(guest.getGender());
			 * g2.setIdType(guest.getIdType()); g2.setPhone(guest.getIdType());
			 */
			r2.setCheckindate(room.getCheckindate());
			r2.setCheckoutdate(room.getCheckoutdate());
			r2.setPrice(room.getPrice());
			r2.setRoomtype(room.getRoomtype());
			
			
			
		}
		return null;
	}

	@Override
	public Room getOne(Long id) {
		// TODO Auto-generated method stub
		return roomrepository.findById(id).get();
	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return roomrepository.findAll(new Sort(Sort.Direction.ASC,"checkindate"));
	}

	

}
