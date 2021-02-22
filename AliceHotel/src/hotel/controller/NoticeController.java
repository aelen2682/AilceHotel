package hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.model.Notice;
import hotel.model.Pagination;
import hotel.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@GetMapping("/insert")
	public String InsertNotice() {
		return "boardForm";
	}

	@PostMapping("/insert")
	public String InsertNotice(Notice notice) {
		noticeService.insertNotice(notice);
		return "resultAddBoard";
	}

	@GetMapping("/delete")
	public String DeleteNotice(int id) {
		noticeService.deleteNotice(id);
		return "resultAddBoard";
	}

	//게시글 수정 상세내용 불러오기
	@GetMapping("/view")
	public String DetailNotice(int id, Model model) {
		Notice data = noticeService.detailNotice(id);
		model.addAttribute("data", data);
		return "boardView";
	}

	//게시글 수정 실행
	@PostMapping("/update")
	public String UpdateNotice(Notice notice) {
		noticeService.updateNotice(notice);
		System.out.println("값:"+notice);
		return "";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getNoticeList(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			) {
		
//		System.out.println(page+range);
		//전체 게시글 개수
		int listCnt = noticeService.getNoticeListCnt();		
		//Pagination 객체생성
		Pagination pagination = new Pagination();
		
		pagination.pageInfo(page, range, listCnt);
//		System.out.println(pagination);
		model.addAttribute("pagination", pagination);
		model.addAttribute("noticeList",  noticeService.getNoticeList(pagination));
		return "";
	}
}

