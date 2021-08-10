package twisercity.library.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import twisercity.library.entities.concretes.Member;

public interface MemberRepository extends JpaRepository<Member,Integer>{

	List<Member> findByFullName(String fullName);
}
