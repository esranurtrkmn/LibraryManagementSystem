package twisercity.library.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twisercity.library.business.abstracts.ReservationService;
import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.core.utilities.results.SuccessDataResult;
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
		
		Reservation reservation=this.reservationRepo.getById(id);
		Book book=this.getBookById(reservation.getBook().getBookId()).getData();
		
		book.setBookStatus(false);
		this.reservationRepo.updateIsBorrowed(isBorrowed,id);
		
		
		return new SuccessResult(id+" nolu rezervasyon güncellenmiştir.");
	}



	@Override
	public Result add(Reservation reservation) {
		
		Book book=this.getBookById(reservation.getBook().getBookId()).getData();
		Member member=getMemberById(reservation.getMember().getMemberId()).getData();
		try {
			if(book.getBookStatus()==false) {
				book.setBookStatus(true);
				reservation.setIsBorrowed(true);
				this.reservationRepo.save(reservation);
				
				
				
				
				return new SuccessResult(book.getBookTitle()+" isimli kitap "+member.getFullName()+" isimli üyeye ödünç verilmiştir.");
				
			}
		}
		 catch (Exception e) {
			 System.out.println(e);  
			 
	 }
		
		return new SuccessResult("Kitap zaten rezervli.");
		
	}

	

	public DataResult<Book> getBookById(int id){
		
		return new SuccessDataResult<Book>(this.bookRepository.getById(id),"başarılı");
		
	}
	
    public DataResult<Member> getMemberById(int id){
		
		return new SuccessDataResult<Member>(this.memberRepository.getById(id),"başarılı");
		
	}

    


	@Override
	public DataResult<List<Reservation>> getAll() {
		return new SuccessDataResult<List<Reservation>>(this.reservationRepo.findAll(),"başarılı");
	}



	@Override
	public DataResult<List<Reservation>> getAllActiveReservations() {
		return new SuccessDataResult<List<Reservation>>(this.reservationRepo.getAllActiveReservations(),"güncel rezervasyon bilgileri listelendi.");
	}



	@Override
	public DataResult<List<Reservation>> getAllPassiveReservations() {
		return new SuccessDataResult<List<Reservation>>(this.reservationRepo.getAllPassiveReservations(),"geçmiş rezervasyon kayıtları listelendi.");
	}

}
