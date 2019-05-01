

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class Main {

	public static void main(String[] args) {
		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try {
			    transaction.begin();
			    
			    Flight flight = new Flight(32, "yyyy.MM.dd G at HH:mm:ss z" , "yyyy.MM.dd G at HH:mm:ss z", 42);
			    Airport airport = new Airport(1342, "Loiu");
			    Reservation reservation = new Reservation(351, 12, 432, "yyyy.MM.dd G at HH:mm:ss z", 130.50, "$");
			    User user = new User("julen.elcoro@opendeusto.es", "Visa", "Google");
			    //Passenger passenger = new Passenger(0, , null, 0);
			    //Reservation_passenger reservation_passenger = new Reservation_passenger("My Inventory");
			    flight.getBookings().add(reservation);		    
			    persistentManager.makePersistent(flight);
			    
			    System.out.println("- Inserted into db: " + flight.total_seats);
			    
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			} finally {		    
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try {
			    transaction.begin();
	
			    @SuppressWarnings("unchecked")
				Query<Flight> flightsQuery = persistentManager.newQuery("SELECT FROM " + Flight.class.getName() + " WHERE total_seats > 30 ORDER BY total_seats");
			    
			    for (Flight flight : flightsQuery.executeList()) {
			        System.out.println("- Selected from db: " + flight.flight_number);
			        persistentManager.deletePersistent(flight);
			        System.out.println("- Deleted from db: " + flight.flight_number);
			    }
	
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception executing a query: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
	
			    persistentManager.close();
			}
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}

	}

}
