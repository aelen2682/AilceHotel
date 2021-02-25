package hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.model.Reservation;
import hotel.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	//예약 찾기 메서드.
	@RequestMapping(value = "/r", method = RequestMethod.GET)
	public String reservation(HttpSession session, Model model) {
		String confirmation_payment = reservationService.PayCheck((String) session.getAttribute("m_id"));
		model.addAttribute("confirmation_payment", confirmation_payment);
		return "/reservation/reservation";
	}
	
	@RequestMapping(value = "/reservation1", method = RequestMethod.POST)
	public String reservation(Reservation reservation, HttpSession session, Model model) throws ParseException {
		reservation.setUserId((String) session.getAttribute("userId"));
		int duplicateFind = reservationService.DuplicateFind(reservation);
		if (duplicateFind >= 1) {
			model.addAttribute("duplicateFind", duplicateFind);
			return "/reservation/ReservationCheck";
		}
		String id = (UUID.randomUUID().toString());
		reservation.setId(id);
		
		System.out.println("reservation : " + reservation);
		
		reservationService.reservation_number(reservation);
		int RoomPrice = reservationService.RoomPrice(reservation);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		Date beginDate = formatter.parse(reservation.getReservationDateIn()); 
		Date endDate = formatter.parse(reservation.getReservationDateOut()); 
		long diff = endDate.getTime() - beginDate.getTime(); 

		long diffDays = diff / (24 * 60 * 60 * 1000) + 1;

		int price = RoomPrice * (int) diffDays;
		reservation.setPrice(price);
		reservationService.reservationInsert(reservation);
		model.addAttribute("model", reservation);
		return "/reservation/ReservationCheck";
	}
	
	@RequestMapping(value = "/ReservationPay", method = RequestMethod.GET)
	public String ReservationPay(@RequestParam("id") String id) {
		reservationService.PayCheckUpdate(id);
		return "/index";
	}

	@RequestMapping(value = "/ReservationSelect", method = RequestMethod.GET)
	public String ReservationSelect(HttpSession session, Reservation reservation, Model model) {
		String confirmation_payment = reservationService.PayCheck((String) session.getAttribute("userId"));
		reservation = reservationService.ReservationSelect((String) session.getAttribute("userId"));
		model.addAttribute("confirmationPayment", confirmation_payment);
		model.addAttribute("model", reservation);
		return "/reservation/ReservationSelect";

	}

	@RequestMapping(value = "/ReservationCancel", method = RequestMethod.POST)
	public String ReservationCancel() {
		reservationService.ReservationDelete();
		return "/index";
	}

	@ResponseBody
	@RequestMapping(value = "/ReservationPasswordCheck", method = RequestMethod.POST)
	public boolean PasswordCheck(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		String SearchPW = reservationService.SearchPW(userId);
		if (SearchPW.equals(password)) {
			reservationService.ReservationDelete();
			
			return true;
		} else
			return false;
	}
}	
