package twisercity.library.business.abstracts;

import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Reservation;

public interface ReservationService {

	public Result add(Reservation reservation);
	
	public Result updateIsBorrowed(boolean isBorrowed, int id);
	

}
