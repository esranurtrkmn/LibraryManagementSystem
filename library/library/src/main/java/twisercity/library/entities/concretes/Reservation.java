package twisercity.library.entities.concretes;


import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="reservation")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="starting_date")	
	private Date startingDate;
	
	@Column(name="is_borrowed")
	private Boolean isBorrowed;
	
	@ManyToOne()
	@JoinColumn(name="member_id")
	private Member member;
	
	@ManyToOne()
	@JoinColumn(name="book_id")
	private Book book;
}
