package twisercity.library.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import twisercity.library.entities.concretes.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

	
	
	
	@Modifying
	@Transactional
	@Query("update Reservation u set u.isBorrowed=:isBorrowed where u.id=:id")
	void updateIsBorrowed(boolean isBorrowed, int id);
	
	
}

/*
update

*/