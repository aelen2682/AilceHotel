package hotel.model;

public class Reservation {

	private int id;
	private String reservationName;
	private String reservationDate;
	private String userId;
	private String name;
	private String phone;
	private int price;
	
	public Reservation() {}

	public Reservation(int id, String reservationName, String reservationDate, String userId, String name, String phone,
			int price) {
		super();
		this.id = id;
		this.reservationName = reservationName;
		this.reservationDate = reservationDate;
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationName=" + reservationName + ", reservationDate=" + reservationDate
				+ ", userId=" + userId + ", name=" + name + ", phone=" + phone + ", price=" + price + "]";
	}
}
