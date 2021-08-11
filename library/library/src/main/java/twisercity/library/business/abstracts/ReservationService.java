package twisercity.library.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Reservation;

public interface ReservationService {

	public Result add(Reservation reservation);
	
	public Result updateIsBorrowed(boolean isBorrowed, int id);
	
	public DataResult<List<Reservation>> getAll();
	
	public DataResult<List<Reservation>> getAllActiveReservations();

	
	public DataResult<List<Reservation>> getAllPassiveReservations();
	

}
