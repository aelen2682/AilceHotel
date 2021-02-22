package hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import hotel.model.Notice;
import hotel.model.Pagination;

@Repository
@Mapper
public interface NoticeMapper {
	
	//작성
	@Insert("insert into notice(title, detail, writer, date) values(#{title}, #{detail}, #{writer}, #{date} )")
	public int insertNotice(Notice notice);
	
	//삭제
	@Delete("delete from notice where id=#{id}")
	public int deleteNotice(int id);
	
	//게시물 상세내용 
	@Select("select * from notice where id=#{id}")
	public Notice detailNotice(int id);
	
	//수정
	@Update("update notice set title=#{title}, detail=#{detail}, writer=#{writer} date id=#{date}")
	public int updateNotice(Notice notice);
	
	//총 게시글 개수 확인
	@Select("select count(*) as listCnt from notice")
	public int getNoticeListCnt();

	//목록보기
	@Select("select * from notice  order by id desc limit #{startList}, #{listSize}")
	public List<Notice> getNoticeList(Pagination pagination);

}
