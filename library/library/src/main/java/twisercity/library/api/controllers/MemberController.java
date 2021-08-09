package twisercity.library.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import twisercity.library.business.abstracts.MemberService;
import twisercity.library.core.utilities.results.DataResult;
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
	
	@GetMapping("/getall")
    public DataResult<List<Member>> getAll() {
       return this.memberService.getAll();
    }
	
}
