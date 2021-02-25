package hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.mapper.ReservationMapper;
import hotel.model.Reservation;

@Service
public class ReservationService {

	@Autowired
	ReservationMapper reservationMapper;

	public void reservation_number(Reservation reservation) {
		reservationMapper.reservateion_number(reservation);
	}

	public int RoomPrice(Reservation reservation) {
		return reservationMapper.RoomPrice(reservation);
	}
	
	public void reservationInsert(Reservation reservation) {
		reservationMapper.reservationInsert(reservation);
	}
	
	public String PayCheck(String userId) {
		return reservationMapper.PayCheck(userId);
	}
	
	public int DuplicateFind(Reservation reservation) {
		return reservationMapper.DuplicateFind(reservation);
	}
	
	public void PayCheckUpdate(String id) {
		reservationMapper.PayCheckUpdate(id);

	}
	public void ReservationDelete() {
		reservationMapper.ReservationDelete();
		
	}
	public Reservation ReservationSelect(String userId) {
		return reservationMapper.ReservationSelect(userId);
	}
	
	public String SearchPW(String userId) {
		return reservationMapper.SearchPW(userId);
	}
}
