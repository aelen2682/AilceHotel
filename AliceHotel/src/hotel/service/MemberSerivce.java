package hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.mapper.MemberMapper;
import hotel.model.Member;

@Service
public class MemberSerivce {
	

	@Autowired
	MemberMapper memberMapper;

	//page_user 리스트 
	public List<Member> MemberList() {
		return memberMapper.selectAll();
	}

	//page_user 추가
	public int InsertMember(Member member) {
		return memberMapper.insertMember(member);
	}

	//page_user ID 중복.
	public Member SelectMemberById(String userId) {
		return memberMapper.selectOneById(userId);
	}
	
	//page_user Count
	public int SelectCountById(String userId) {
		return memberMapper.selectCountById(userId);
	}
	
	//page_user Update
	public int UpdateMember(Member member) {
		return memberMapper.updateMember(member);
	}
	
	//page_user Delete
	public int DaleteMember(int id) {
		return memberMapper.deletePage_User(id);
	}
	
	//page_user LoginChecking
	public int LoginChecking(String userId, String password){

		Member getUserId = memberMapper.selectOneById(userId);

		System.out.println("getUserId:"+getUserId);

		int getId = 0; 
		
		int num;

		if (getUserId == null) {

			getId = 0;

			System.out.println("getId : " + getId);

		} else {

			getId = getUserId.getId();
			
			System.out.println("고유번호:"+getId);
			System.out.println("유저ID: "+getUserId.getUserId());
			System.out.println("유저 Password : " + getUserId.getPassword());
			System.out.println("입력받은 password : " + password);
		}
			
		if (getId == 0) {
			
			return 0;
		}
		if (getUserId.getPassword().equals(password)) {
			
			return 1;
			
		} else {
			
			num = 2;
		}
		return num;
	}
	
	//아이디 중복 확인
    public boolean Select_Boolean_MemberById(String userId) {
    	
    	boolean result = false;
    	
    	Member user = memberMapper.selectOneById(userId);
    	
    	String user_id = user.getUserId();

    	//서버의 없을 시 : 참, 중복 아이디 있을 시 : 거짓을 판별해서 리턴함
        if (user_id.equals(null)) {
        	result = true;
        }
        
        return result;
    }
}
