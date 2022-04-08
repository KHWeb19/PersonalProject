package com.example.demo;

import com.example.demo.entity.jpa.MemberTest;
import com.example.demo.repository.MemberTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MemberTestRepository repository;

	@Test
	void contextLoads() {
		MemberTest mt = new MemberTest("test", "gogosing");
		repository.save(mt);
	}

}
