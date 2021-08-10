package twisercity.library.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twisercity.library.business.abstracts.ReservationService;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.core.utilities.results.SuccessResult;
import twisercity.library.dataAccess.abstracts.BookRepository;
import twisercity.library.dataAccess.abstracts.MemberRepository;
import twisercity.library.dataAccess.abstracts.ReservationRepository;
import twisercity.library.entities.concretes.Book;
import twisercity.library.entities.concretes.Member;
import twisercity.library.entities.concretes.Reservation;

@Service
public class ReservationManager implements ReservationService{

	private ReservationRepository reservationRepo;	
	
	private BookRepository bookRepository;	
	
	private MemberRepository memberRepository;
	
	@Autowired
	public ReservationManager(ReservationRepository reservationRepo, BookRepository bookRepository,
			MemberRepository memberRepository) {
		super();
		this.reservationRepo = reservationRepo;
		this.bookRepository = bookRepository;
		this.memberRepository = memberRepository;
	}
	
	

	@Override
	public Result updateIsBorrowed(boolean isBorrowed, int id) {
		
		this.reservationRepo.updateIsBorrowed(isBorrowed,id);
		
		return new SuccessResult(id+"nolu rezervasyon güncellenmiştir.");
	}



	@Override
	public Result add(Reservation reservation) {
		
		Book book=new Book();
		Member member=new Member();
		
		this.reservationRepo.save(reservation);
		
		
		return new SuccessResult(book.getBookAuthor()+"isimli kitap "+member.getFullName()+"isimli üyeye ödünç verilmiştir.");
	}


	

}
