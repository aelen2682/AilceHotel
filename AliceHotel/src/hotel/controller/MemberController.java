package hotel.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.model.Member;
import hotel.service.MemberSerivce;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	MemberSerivce memberService;

	@RequestMapping("/LoginLogOut")
	public String LoginLogout() {
		return "/member/LoginLogOut";
	}

	@RequestMapping("/MemberInsert")
	public String MemberInsert() {
		return "/member/MemberInsert";
	}

	//회원가입
	@RequestMapping(value = "/family", method = RequestMethod.POST)
	public String MemberFamily(Member member) {

		memberService.InsertMember(member);

		System.out.println("가입된 user : " +member);
		return "/member/JoinSuccess";
	}

	@ResponseBody
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public int loginCheck(Member member, HttpSession session) {//, HttpSession session

		String userId = member.getUserId();
		String password = member.getPassword();
		
		System.out.println("입력받은 값 : " + userId +","+ password);

		int num = 0;

		num = memberService.LoginChecking(userId, password);//, session	

		System.out.println("num :"+ num);

		if (num == 0) {
		
			System.out.println("아이디가 일치하지 않습니다.");
			
		} else if (num == 1) {
			
			Member User = memberService.SelectMemberById(userId);
			
			System.out.println("로그인 ID : " + User);
			System.out.println("로그인 성공!");
			session.setAttribute("userId", User.getUserId());
		} else {

			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		return num;
		
	}

	private static final Pattern ID_REGEX = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$");

	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public int idcheck(@RequestParam("userId") String userId) {
		Member Check = memberService.SelectMemberById(userId);
		if (Check == null) {
			if (ID_REGEX.matcher(userId).matches()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 0;
		}
	}
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
}