package hotel.model;

public class Reservation {

	private String id;
	private String userId;
	private String reservationDateIn;
	private String reservationDateOut;
	private String roomType;
	private boolean confirmationPayment;
	private int adult;
	private int child;
	private int price;
	
	public Reservation() {}

	public Reservation(String id, String userId, String reservationDateIn, String reservationDateOut, String roomType,
			boolean confirmationPayment, int adult, int child, int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.reservationDateIn = reservationDateIn;
		this.reservationDateOut = reservationDateOut;
		this.roomType = roomType;
		this.confirmationPayment = confirmationPayment;
		this.adult = adult;
		this.child = child;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReservationDateIn() {
		return reservationDateIn;
	}

	public void setReservationDateIn(String reservationDateIn) {
		this.reservationDateIn = reservationDateIn;
	}

	public String getReservationDateOut() {
		return reservationDateOut;
	}

	public void setReservationDateOut(String reservationDateOut) {
		this.reservationDateOut = reservationDateOut;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isConfirmationPayment() {
		return confirmationPayment;
	}

	public void setConfirmationPayment(boolean confirmationPayment) {
		this.confirmationPayment = confirmationPayment;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userId=" + userId + ", reservationDateIn=" + reservationDateIn
				+ ", reservationDateOut=" + reservationDateOut + ", roomType=" + roomType + ", confirmationPayment="
				+ confirmationPayment + ", adult=" + adult + ", child=" + child + ", price=" + price + "]";
	}
}
