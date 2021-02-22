package hotel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.model.Reservation;
import hotel.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@GetMapping("/list")
	public String ReservationList(Model m, Reservation reservation, HttpSession session) {

		String userId = (String)session.getAttribute("userId");

		System.out.println("userId : "+ userId );
		List<Reservation> ReservationList = reservationService.SelectListMemberById(userId);
		session.setAttribute("ReservationList", ReservationList);
		System.out.println("UserList : "+ ReservationList);

		return "reservationList";
	}

	@PostMapping("/insert")
	@ResponseBody
	public int ReservationInsert(Model m, Reservation reservation) {

		String reservationDate = reservation.getReservationDate();
		String reservationName = reservation.getReservationName();
		System.out.println(reservation);
		System.out.println("입력받은 값 : " + reservationDate +","+ reservationName);

		int num = 0;

		num = reservationService.DateChecking(reservationDate, reservationName);	

		System.out.println("num :"+ num);

		if (num == 0) {
			String userId = reservation.getUserId();
			System.out.println("userId: " + userId);

			reservationService.InsertMemberReservation(reservation);
			System.out.println("예약완료!");

		} else if (num == 1) {

			System.out.println("예약이 이미 되어 있습니다.");

		} else {

			System.out.println("예약 날짜의 예약 가능합니다.");
		}

		return num;
	}

	@GetMapping("/updateForm")
	public String updateForm(int id, Model m) {
		Reservation reservation = reservationService.selectById(id);
		m.addAttribute("reservation", reservation);
		return "reservationUpdate";
	}


	@PostMapping("/update")
	public String ReservationUpdate(Reservation reservation) {

		System.out.println("입력받은 값 : " + reservation);

		String userId = reservation.getUserId();
		System.out.println("Cont userId: " + userId );

		reservationService.UpdateMember(reservation);
		System.out.println("예약 수정완료!");

		return "redirect:list";
	}

	@GetMapping("/delete")
	public String RsDelete(int id) {
		reservationService.DeleteMember(id);
		return "redirect:list";
	}
}	
