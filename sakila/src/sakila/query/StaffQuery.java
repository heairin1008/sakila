package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY = "SELECT email, username FROM staff WHERE email = ? AND password = PASSWORD(?)";
	public final static String SELECT_STAFF_INFO = "SELECT staff.username, v.name, v.phone, v.address, v.city, v.country, staff.email FROM staff_list AS v JOIN staff ON v.ID = staff.staff_id WHERE staff.staff_id = ?";
}
