package com.example.demo.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Service.GuestService;
import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;

@Service
@Transactional
public class GuestServiceImpl implements GuestService{
	private GuestRepository guestrepository;

	public GuestServiceImpl(GuestRepository guestrepository) {
		super();
		this.guestrepository = guestrepository;
	}

	@Override
	public Guest insert(Guest guest) {
		// TODO Auto-generated method stub
		Guest guest1=guestrepository.save(guest);
		return guest1;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		guestrepository.deleteById(id);
	}

	@Override
	public Guest update(Guest guest, Long id) {
		// TODO Auto-generated method stub
		Optional<Guest> g1=guestrepository.findById(id);
		if(g1.isPresent()) {
			Guest g2=g1.get();
			g2.setFirstName(guest.getFirstName());
			g2.setLastName(guest.getLastName());
			g2.setAddress(guest.getAddress());
			g2.setGender(guest.getGender());
			g2.setIdType(guest.getIdType());
			g2.setPhone(guest.getIdType());
			
		}
		return null;
	}

	@Override
	public Guest getOne(Long id) {
		// TODO Auto-generated method stub
		return guestrepository.findById(id).get();

	}

	@Override
	public List<Guest> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
