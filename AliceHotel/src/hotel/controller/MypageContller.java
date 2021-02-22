package hotel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.model.Member;
import hotel.service.MemberSerivce;

@Controller
@RequestMapping("/MyPage")
public class MypageContller {
	
	@Autowired
	MemberSerivce memberSerivce;
	
	@GetMapping("/Information")
	public String updatePage() {
		
		return "";
	}
	
	@PostMapping("/Update")
	public String updatePage(Member member) {
		
		memberSerivce.UpdateMember(member);
		System.out.println("수정 후: "+ member);
		
		return "";
	}

	//딜리트 페이지로 이동
	@RequestMapping(value = "/mypageDelete", method = RequestMethod.GET)
	public String deleteForm() {
		System.out.println("딜리트 이동!");
		return "";
	}
	
	//회원 탈퇴
	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public String deleteCheck(Member member, HttpSession session, RedirectAttributes rttr) {
		
		String userId = (String) session.getAttribute("userId");
		System.out.println("session: " + userId);
		
		Member user = memberSerivce.SelectMemberById(userId);
		System.out.println("select한 정보: " + user);
		int id = user.getId();
		String password = user.getPassword();
		System.out.println("select한 password: " + password);
		String inputPw = member.getPassword();
		System.out.println("입력받은  password: " + inputPw);
		
		if (!(password.equals(inputPw))) {
			System.out.println("비밀번호 틀림");
			rttr.addFlashAttribute("msg", false);
			return "redirect:/MyPage/mypageDelete";
		}
		memberSerivce.DaleteMember(id);
		System.out.println("삭제완료");
		session.invalidate();
		
		return "index"; 
	}
}
