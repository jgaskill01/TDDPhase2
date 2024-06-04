package com.example.phase_two_tdd_full_stack.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class CourseControllerTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  CourseService courseService;

  @Autowired
  ObjectMapper objectMapper;


    @Test
    void shouldAcceptPostRequestsToCreateACourse() throws Exception {
        Course course = new Course(null, "title", "description", "number");
        Course newCourse = new Course(1L, "title", "description", "number");

        when(courseService.createCourse(any(Course.class))).thenReturn(newCourse);

      mvc.perform(MockMvcRequestBuilders.post("/api/course")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(objectMapper.writeValueAsString(newCourse)))
              .andExpect(status().isCreated());

              var captor = ArgumentCaptor.forClass(Course.class);
      verify(courseService).createCourse(captor.capture());
      assertThat(captor.getValue()).usingRecursiveComparison().isEqualTo(newCourse);
    }

    @Test
    void shouldAcceptPostRequestsToCreateACourse2() throws Exception {
        Course course = new Course(null, "title", "description", "number");
        Course newCourse = new Course(1L, "title", "description", "number");

        when(courseService.createCourse(any(Course.class))).thenReturn(newCourse);

        mvc.perform(MockMvcRequestBuilders.post("/api/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCourse)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(newCourse)));

        verify(courseService).createCourse(newCourse);
    }
}
