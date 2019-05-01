
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Airport {

	@PrimaryKey
    int code = 0;
	String place;
	
	public Airport(int code, String place) {
		this.code = code;
		this.place = place;
	}
	
	Set<Flight> departure_flights = new HashSet<>();
	Set<Flight> arrival_flights = new HashSet<>();
	Set<User> usuarios = new HashSet<>();

	public Airport(int code, String place, Set<Flight> departure_flights, Set<Flight> arrival_flights,
			Set<User> usuarios) {
		super();
		this.code = code;
		this.place = place;
		this.departure_flights = departure_flights;
		this.arrival_flights = arrival_flights;
		this.usuarios = usuarios;
	}

	public Set<Flight> getDeparture_flights() {
		return departure_flights;
	}
	public Set<Flight> getArrival_flights() {
		return arrival_flights;
	}
	public Set<User> getUsuarios() {
		return usuarios;
	}
}
