package hotel.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	//회원가입 폼으로 이동.
	@GetMapping("/joinForm")
	public String getPage_User() {
		return "page_User";
	}

	//회원가입
	@PostMapping("/join")
	public String insertPage_User(Member member) {

		System.out.println("user: "+ member);
		memberService.InsertMember(member);

		System.out.println("가입된 user : " +member);
		return "/member/JoinSuccess";
	}

	@PostMapping("/login")
	@ResponseBody
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
			session.setAttribute("password", User.getPassword());
			session.setAttribute("name", User.getName());
			session.setAttribute("phone", User.getPhone());
			session.setAttribute("manager", User.getManager());
		} else {

			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		return num;
		
	}

	@RequestMapping("/idcheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userId) {
		
		System.out.println(userId);
		int count = 0;

		Map<Object, Object> map = new HashMap<Object, Object>();
		
		count = memberService.SelectCountById(userId);

		if (count == 0) {
		}
		
		map.put("cnt", count);

		return map;
	}
}