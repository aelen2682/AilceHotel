package hotel.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.model.Reservation;


@Mapper
public interface ReservationMapper {

	//결제확인
	@Select("select confirmation_payment from reservation where user_id = #{userId}")
	public String PayCheck(String userId);
	
	@Select ("select count(*) from reservation r join reservation_number n on r.id = n.id where "
			+ "room_type in (#{roomType}) and ( #{reservationDateIn} BETWEEN reservation_date_in "
			+ "AND reservation_date_out OR #{reservationDateOut} BETWEEN reservation_date_in AND reservation_date_out)")
	public int DuplicateFind(Reservation reservation);
	
	@Insert("insert into reservation_number (id, room_type, adult, child) " + 
			"values(#{id}, #{roomType}, #{adult}, #{child})")
	public void reservateion_number(Reservation reservation);
	
	@Select("select room_price from room_information where room_type = #{roomType}")
	public int RoomPrice(Reservation reservation);
	
	@Insert("	insert into reservation (id ,user_id,reservation_date_in, reservation_date_out, "
			+ "confirmation_payment, price) values (#{id},#{userId},#{reservationDateIn},"
			+ "#{reservationDateOut},#{confirmationPayment},#{price})")
	public void reservationInsert(Reservation reservation);
	
	@Update("update reservation set confirmation_payment = 1 where id = #{id}")
	public void PayCheckUpdate(String id);
	
	@Select("select * from reservation r join reservation_number n on r.id = n.id where user_id = #{userId}")
	public Reservation ReservationSelect(String userId);
	
	@Select("select password from member where user_id = #{userId}")
	public String SearchPW(String userId);

	@Delete("delete from reservation_number")
	public void ReservationDelete();
}