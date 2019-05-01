
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reservation {

	@PrimaryKey
	int id;
	int num_seats = 0;
	//HEMOS ELIMINADO LA CLASE DE PAGO PARA SIMPLICAR EL DISEÑO. SE AÑADEN EN RESERVA LOS ATRIBUTOS DE PAGO Y SE PUEDEN ACCEDER A TRAVES DE L ARRAY DE USUARIOS
	int payment_code = 0;
	String payment_date;
	Double price = 0.00;
	String currency;

	public Reservation(int id, int num_seats, int payment_code, String payment_date, Double price, String currency) {
		super();
		this.id = id;
		this.num_seats = num_seats;
		this.payment_code = payment_code;
		this.payment_date = payment_date;
		this.price = price;
		this.currency = currency;
	}
}
