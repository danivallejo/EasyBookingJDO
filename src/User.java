
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.ForeignKey;

@PersistenceCapable
public class User {

	@PrimaryKey
    String email;
	String payment_name;
	String aut_sys_name;
	
	Set<Reservation> bookings = new HashSet<>();
	// List < Collection< Reservation, Payment>  >
	
	public User(String email, String payment_name, String aut_sys_name) {
		this.email = email;
		this.payment_name = payment_name;
		this.aut_sys_name = aut_sys_name;
	}
	
	public Set<Reservation> getBookings() {
		return bookings;
	}
}
