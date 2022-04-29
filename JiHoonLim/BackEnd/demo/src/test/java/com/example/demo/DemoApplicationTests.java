package com.example.demo;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.MemberCart;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import com.example.demo.repository.Member.MemberCartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	MemberCartRepository memberCartRepository;

	@Autowired
	FoodBoardRepository foodBoardRepository;

	@Test
	void 테스트() {
		Optional<FoodBoard> maybeFoodBoard = foodBoardRepository.findById(1L);
		FoodBoard foodBoard = maybeFoodBoard.get();
		System.out.println(foodBoard.getBoardNo() + ", " + foodBoard.getFilename() + ", " + foodBoard.getContent());
	}

	@Test
	void 찾기테스트() {
		//List<FoodBoard> foodBoardList = foodBoardRepository.selectFoodWithMemberNo(12L);
		List<FoodBoard> foodBoardList = foodBoardRepository.findFoodBoardListByMemberCart(12L);
		System.out.println("Got it!!! - " + foodBoardList.get(0).getBoardNo());
		System.out.println("Got it!!! - " + foodBoardList.get(0).getFilename());
	}

}
