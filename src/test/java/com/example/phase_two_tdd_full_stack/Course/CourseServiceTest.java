package com.example.phase_two_tdd_full_stack.Course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    void shouldSaveNewCourseToTheDatabase() {
        Course course = new Course(null, "title", "description", "number");
        Course saved = courseService.createCourse(course);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved).usingRecursiveComparison().ignoringFields("id").isEqualTo(course);










    }

}