
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Flight {
	
	@PrimaryKey
    int flight_number;
	String departure_date;
	String arrival_date;
	int total_seats;
    Set<Reservation> bookings = new HashSet<>();

    
    public Flight(int flight_number, String departure_date, String arrival_date, int total_seats
			) {
		super();
		this.flight_number = flight_number;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.total_seats = total_seats;
		this.bookings = bookings;
	}
	public Set<Reservation> getBookings() {
    	return bookings;
    	}


}
