package twisercity.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twisercity.library.business.abstracts.MemberService;
import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Member;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	private MemberService memberService;

	
	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Member member) {
		return this.memberService.add(member);
	}
	
	@GetMapping("/getall")
    public DataResult<List<Member>> getAll() {
       return this.memberService.getAll();
    }
	
	@GetMapping("/findbyfullname")
	public DataResult<List<Member>> findByFullName(@RequestParam String fullName){
		return this.memberService.findByFullName(fullName);
	}
	
}
