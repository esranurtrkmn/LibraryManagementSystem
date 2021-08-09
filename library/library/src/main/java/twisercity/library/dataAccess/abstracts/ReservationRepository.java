package twisercity.library.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import twisercity.library.entities.concretes.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

}
