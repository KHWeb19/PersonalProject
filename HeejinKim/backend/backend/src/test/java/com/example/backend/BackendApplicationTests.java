package com.example.backend;

import com.example.backend.entity.Member;
import com.example.backend.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	void 이거생성안되냐() {
		/*Member member = new Member//("~~~blabla");
		memberRepository.save(member);*/
	}

}
