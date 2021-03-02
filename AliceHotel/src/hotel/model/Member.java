package hotel.model;

public class Member {

	private int id;
	private String userId;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String homeMail;
	private String generalAddress;
	private String detailedAddress;
	
	public Member() {}

	public Member(int id, String userId, String password, String name, String phone, String email, String homeMail,
			String generalAddress, String detailedAddress) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.homeMail = homeMail;
		this.generalAddress = generalAddress;
		this.detailedAddress = detailedAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeMail() {
		return homeMail;
	}

	public void setHomeMail(String homeMail) {
		this.homeMail = homeMail;
	}

	public String getGeneralAddress() {
		return generalAddress;
	}

	public void setGeneralAddress(String generalAddress) {
		this.generalAddress = generalAddress;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", homeMail=" + homeMail + ", generalAddress=" + generalAddress
				+ ", detailedAddress=" + detailedAddress + "]";
	}
}
