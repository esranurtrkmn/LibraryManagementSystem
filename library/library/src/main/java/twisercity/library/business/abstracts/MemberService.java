package twisercity.library.business.abstracts;

import java.util.List;

import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Member;


public interface MemberService {

	public DataResult<List<Member>> getAll();
	
	public DataResult<List<Member>> findByFullName(String fullName);
	
	public Result add(Member member);
}
