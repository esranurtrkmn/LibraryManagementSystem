package twisercity.library.entities.concretes;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="book")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservations"})
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int bookId;
	
	@Column(name="book_title")
	private String bookTitle;
	
	@Column(name="book_author")
	private String bookAuthor;
	
	@Column(name="first_publish_date")
	private LocalDate firstPublishDate;
	
	@Column(name="edition_date")
	private LocalDate editionDate;
	
	@Column(name="edition_number")
	private String editionNumber;
	
	@Column(name="book_type")
	private String bookType;
	
	@Column(name="cover_type")
	private String coverType;
	
	@OneToMany(mappedBy="book")
	@JsonIgnore
	private List<Reservation> reservations;
	
}
