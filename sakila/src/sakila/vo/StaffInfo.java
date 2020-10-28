package sakila.vo;

public class StaffInfo {
	private String userName;
	private int staffId;
	private String fullName;
	private String address;
	private String zipCode;
	private String phone;
	private String city;
	private String country;
	private String email;
	private int storeId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "StaffInfo [userName=" + userName + ", staffId=" + staffId + ", fullName=" + fullName + ", address="
				+ address + ", zipCode=" + zipCode + ", phone=" + phone + ", city=" + city + ", country=" + country
				+ ", email=" + email + ", storeId=" + storeId + "]";
	}
}
