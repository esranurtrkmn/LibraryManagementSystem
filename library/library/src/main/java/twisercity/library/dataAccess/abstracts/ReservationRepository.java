package twisercity.library.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import twisercity.library.entities.concretes.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

		
	@Modifying
	@Transactional
	@Query("update Reservation u set u.isBorrowed=:isBorrowed where u.id=:id")
	void updateIsBorrowed(@Param("isBorrowed") boolean isBorrowed,@Param("id") int id);
	
	@Query("FROM Reservation WHERE isBorrowed=true")
	List<Reservation> getAllActiveReservations();

	@Query("FROM Reservation WHERE isBorrowed=false")
	List<Reservation> getAllPassiveReservations();
	
}

