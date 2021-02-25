package hotel.controller;

import java.util.List;

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

import com.hotel.DTO.NoticeDTO;

import hotel.model.Notice;
import hotel.model.Pagination;
import hotel.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "/NoticeList", method = RequestMethod.GET)
	public String NoticeList(Model model
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
		return "boardPage";
	}

	@RequestMapping(value = "/NoticeContent", method = RequestMethod.GET)
	public ModelAndView NoticeContent(@RequestParam("id") int id, Notice notice) {
		ModelAndView mav = new ModelAndView();
		noticeService.NoticeCountUpdate(id);
		notice = noticeService.SelectNotice(id);
		mav.addObject("notice", notice);
		mav.setViewName("/notice/NoticeContent");
		return mav;
	}
	
	@RequestMapping(value="/WriteModifiy",method = RequestMethod.POST)
	public String WriteModifiy(NoticeDTO dto) {
		service.NoticeModify(dto);
		return "redirect:/notice/NoticeList";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/NoticeDelete",method=RequestMethod.GET)
	public int NoticeDelete(@RequestParam("b_no") int b_no) {
      service.NoticeDelete(b_no);
      return b_no;
	
	}
	@RequestMapping("/NoticeWrite")
	public String NoticeWrite() {
		return "/notice/NoticeWrite";
	}

	@RequestMapping(value = "/Write", method = RequestMethod.POST)
	public String NoticeWrite(Notice notice) {
		noticeService.NoticeInsert(notice);
		return "redirect:/notice/NoticeList"; // redirect ����� �Ѵ�

	}
}

