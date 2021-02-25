package hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.mapper.NoticeMapper;
import hotel.model.Notice;
import hotel.model.Pagination;

@Service
public class NoticeService {
	
	@Autowired
	NoticeMapper noticeMapper;
	
	//작성
		public int NoticeInsert(Notice notice) {
			return noticeMapper.NoticeInsert(notice);
		}	
		
		//삭제
		public int NoticeDelete(int id) {
			return noticeMapper.NoticeDelete(id);
		}
		
		//수정
		public int NoticeUpdate(Notice notice) {
			return noticeMapper.Noticeupdate(notice);
		}
		
		public Notice NoticeDetail(int id) {
			return noticeMapper.NoticeDetail(id);
		}
		
		//게시물 총 갯수
		public int NoticeListCnt() {
			return noticeMapper.NoticeListCnt();				
		}
		
		//전체조회
		public List<Notice> NoticeList(Pagination pagination){
			return noticeMapper.NoticeList(pagination);
		}
}
