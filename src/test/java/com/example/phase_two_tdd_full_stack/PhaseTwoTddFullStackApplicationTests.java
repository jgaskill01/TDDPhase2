package com.example.phase_two_tdd_full_stack;

import com.example.phase_two_tdd_full_stack.Course.Course;
import com.example.phase_two_tdd_full_stack.Course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PhaseTwoTddFullStackApplicationTests {

	@Autowired
	CourseRepository courseRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void databaseConnectionEstablished() {
		courseRepository.save(new Course(null, "Spring Boot 101", "Spring Boot Introduction", "SB101"));
        assertThat(courseRepository.findAll()).hasSize(1);
		courseRepository.deleteAll();
        assertThat(courseRepository.findAll()).hasSize(0);
	}
}
