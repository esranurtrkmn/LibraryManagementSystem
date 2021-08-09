package twisercity.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twisercity.library.business.abstracts.MemberService;
import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.SuccessDataResult;
import twisercity.library.dataAccess.abstracts.MemberRepository;
import twisercity.library.entities.concretes.Member;

@Service
public class MemberManager implements MemberService {

	private MemberRepository memberRepo;
	
	@Autowired	
	public MemberManager(MemberRepository memberRepo) {
		super();
		this.memberRepo = memberRepo;
	}


	@Override
	public DataResult<List<Member>> getAll() {
		return new SuccessDataResult<List<Member>>(this.memberRepo.findAll(),"Üyeler listelendi");
	}

}
