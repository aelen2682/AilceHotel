package hotel.controller;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import hotel.model.Notice;
import hotel.model.Pagination;
import hotel.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "/NoticeList", method = RequestMethod.GET)
	public String NoticeList(Model model, HttpSession session
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			) {
//		System.out.println(page+range);
		//전체 게시글 개수
		int listCnt = noticeService.NoticeListCnt();			
		//Pagination 객체생성
		Pagination pagination = new Pagination();
		
		pagination.pageInfo(page, range, listCnt);
//		System.out.println(pagination);
		model.addAttribute("pagination", pagination);
		model.addAttribute("NoticeList",  noticeService.NoticeList(pagination));
		return "/notice/NoticeList";
	}

	@RequestMapping(value = "/NoticeContent", method = RequestMethod.GET)
	public ModelAndView NoticeContent(@RequestParam("id") int id, Notice notice) {
		System.out.println(notice);
		ModelAndView mav = new ModelAndView();
		noticeService.NoticeCountUpdate(id);
		notice = noticeService.NoticeDetail(id);
		mav.addObject("notice", notice);
		mav.setViewName("/notice/NoticeContent");
		return mav;
	}
	
	@RequestMapping(value="/WriteModifiy",method = RequestMethod.POST)
	public String WriteModifiy(Notice notice) {
		noticeService.NoticeModify(notice);
		return "redirect:/notice/NoticeList";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/NoticeDelete",method=RequestMethod.GET)
	public int NoticeDelete(@RequestParam("id") int id) {
		noticeService.NoticeDelete(id);
      return id;
	
	}
	@RequestMapping("/NoticeWrite")
	public String NoticeWrite() {
		return "/notice/NoticeWrite";
	}

	@RequestMapping(value = "/Write", method = RequestMethod.POST)
	public String NoticeWrite(Notice notice) {
		noticeService.NoticeInsert(notice);
		System.out.println("추가된 공지 : " + notice);
		return "redirect:/notice/NoticeList"; 

	}
}

