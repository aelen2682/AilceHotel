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
	public int insertNotice(Notice notice) {
		return noticeMapper.insertNotice(notice);
	}	
	
	//삭제
	public int deleteNotice(int id) {
		return noticeMapper.deleteNotice(id);
	}
	
	//수정
	public int updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}
	
	public Notice detailNotice(int id) {
		return noticeMapper.detailNotice(id);
	}
	
	//게시물 총 갯수
	public int getNoticeListCnt() {
		return noticeMapper.getNoticeListCnt();				
	}
	
	//전체조회
	public List<Notice> getNoticeList(Pagination pagination){
		return noticeMapper.getNoticeList(pagination);
	}
}
