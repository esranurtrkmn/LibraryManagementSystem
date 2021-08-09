package twisercity.library.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import twisercity.library.entities.concretes.Member;

public interface MemberRepository extends JpaRepository<Member,Integer>{

}
