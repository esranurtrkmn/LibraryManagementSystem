package twisercity.library.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twisercity.library.business.abstracts.ReservationService;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Reservation;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	private ReservationService reservationService;

	@Autowired
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Reservation reservation) {
		return this.reservationService.add(reservation);
	}
	
	@PostMapping("/updateisborrowed")
	public Result updateIsBorrowed(@RequestParam boolean isBorrowed, @RequestParam int id) {
		
		return this.reservationService.updateIsBorrowed(isBorrowed, id);
	}
}
