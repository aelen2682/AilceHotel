package hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.model.Member;

@Mapper
public interface MemberMapper {

	//Member 리스트
	@Select("select * from member")
	public List<Member> selectAll();

	//Member 아이디 카운트
	@Select("select count(*) from member where user_id=#{userId}")
	public int selectCountById(String userId);

	//Member Member 아이디 찾기
	@Select("select * from member where user_id=#{userId}")
	public Member selectOneById(String userId);

	//page_user 비밀번호 찾기
	@Select("select * from page_user where password=#{password}")
	public Member selectOneByPassword(String password);
	
	//Member Login
	@Select("select user_id, password from member where user_id=#{userId} and password=#{password}")
	public String selectLogin(Member member);

	//Member 추가
	@Insert("insert into member(user_id, password, name, phone, email, home_mail, "
			+ "general_address, detailed_address) values(#{userId}, #{password}, #{name}, "
			+ "#{phone}, #{email}, #{homeMail}, #{generalAddress}, #{detailedAddress})")
	public int insertMember(Member member);

	//Member phone 업데이트
	@Update("update member set user_id=#{userId}, password=#{password}, name=#{name}, "
			+ "phone=#{phone}, email=#{email}, home_mail=#{homeMail}, general_address=#{generalAddress}, "
			+ "detailed_address=#{detailedAddress} where user_id=#{userId}")
	public int updateMember(Member member);

	//Member 삭제
	@Delete("delete from member where id=#{id}")
	public int deletePage_User(int id);

}
