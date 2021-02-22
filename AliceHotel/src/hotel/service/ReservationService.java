package hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.mapper.ReservationMapper;
import hotel.model.Reservation;

@Service
public class ReservationService {

	@Autowired
	ReservationMapper reservationMapper;

	//Reservation 리스트 
	public List<Reservation> ReservationList() {
		return reservationMapper.selectReservationAll();
	}

	//Reservation id로 정보찾기
	public Reservation selectById(int id) {
		return reservationMapper.selectById(id);
	}

	//Reservation List에서  userId로 정보찾기
	public List<Reservation> SelectListMemberById(String userId) {
		return reservationMapper.selectListUserById(userId);
	}

	//Reservation List에서  reservationDate로 정보찾기
	public List<Reservation> SelectListDateById(String reservationDate) {
		return reservationMapper.selectListByDate(reservationDate);
	}

	//Reservation 중복체크
	public Reservation SelectByDateName(String reservationDate, String reservationName) {
		return reservationMapper.selectByDateName(reservationDate, reservationName);
	}
	
	//Reservation userId로 예약정보 ㅈ찾기.
	public Reservation SelectMemberById(String userId) {
		return reservationMapper.selectReservationUserById(userId);
	}

	//Reservation  추가
	public int InsertMemberReservation(Reservation reservation) {
		return reservationMapper.insertUserIdReservation(reservation);
	}

	//Reservation  수정.
	public int UpdateMember(Reservation reservation) {

		return reservationMapper.updateUserIdReservation(reservation);
	}

	//Reservation 취소
	public int DeleteMember(int id) {

		return reservationMapper.deleteUserReservation(id);
	}

	//Reservation DateChecking
	public int DateChecking(String reservationDate, String reservationName){
		
		System.out.println("Service 입력받은 값 : " + reservationDate +","+ reservationName);
		
		//Reservation getDateName = reMapper.selectByDateName(reservationDate, reservationName);
		//Reservation getDate = reMapper.selectByDate(reservationDate);
		Reservation getDateName = reservationMapper.selectByDateName(reservationDate, reservationName);
		System.out.println("getDateName:"+getDateName);

		int getId = 0; 

		int num = 0;

		if (getDateName == null) {

			getId = 0;

			System.out.println("getId : " + getId);
			
			return 0;

		} else {

				System.out.println("예약 날짜 : "+getDateName.getReservationDate());
				System.out.println("예약 구장 : " + getDateName.getReservationName());
				System.out.println("입력받은 구장 : " + reservationName);

				getId = 1;

				if (getDateName.getReservationName().equals(reservationName)) {

					return 1;

				} else {

					num = 2;
			}
		}
		return num;
	}
}
