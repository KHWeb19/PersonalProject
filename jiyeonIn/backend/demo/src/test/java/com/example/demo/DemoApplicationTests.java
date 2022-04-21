package com.example.demo;

import com.example.demo.entity.booking.BookingInfo;
import com.example.demo.repository.booking.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BookingRepository bookingRepository;
	@Test
	void 테스트() {
		BookingInfo info = new BookingInfo("test33", "2022-06-10", "3시", "예약중",
				"disign");
		bookingRepository.save(info);
	}

}
