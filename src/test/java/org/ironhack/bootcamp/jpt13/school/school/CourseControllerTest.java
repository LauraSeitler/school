package org.ironhack.bootcamp.jpt13.school.school;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ironhack.bootcamp.jpt13.school.school.Repository.CourseRepository;
import org.ironhack.bootcamp.jpt13.school.school.models.Course;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

    public class CourseControllerTest {
        //cntexto d epruebas de spring
        @Autowired
        private WebApplicationContext webApplicationContext;

        @Autowired
        private CourseRepository courseRepository;

        private MockMvc mockMvc;
        private final ObjectMapper objectMapper = new ObjectMapper();

        @BeforeEach
        public void setUp() {
            //web ap context: quiero q hagas las peticiones en este entorno de test
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
            Course course = new Course("CS101", "Intro to Java");
            Course course2 = new Course("CS102", "Databases");
            courseRepository.saveAll(List.of(course, course2));
        }

        @AfterEach
        void tearDown() {
            courseRepository.deleteAll();
        }

        @Test
        void store_Valid_Created() throws Exception {
            Course course = new Course("CS103", "Another course");
            //object mapper convierte objetos de java a json de ese objeto
            String body = objectMapper.writeValueAsString(course);
            //perform envi la peticion
            //larta se guarda en el mvc result
            MvcResult mvcResult = mockMvc.perform(post("/courses")
                    .content(body)
                    .contentType(MediaType.APPLICATION_JSON)

            ).andExpect(status().isCreated()).andReturn();
            //54 creamos un curso y lo convertimos a json, y luego con el mvc hicimos un post y creamos un objetos de
            // tipo....another coruse.y pedimos la rta 201 is created. 66 convertir cadena de text en objeto de tipo curso 7 en la 67 comprobamos que tengan el mismo nombre comprobamos que se creo correctamente.
            Course course1 = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Course.class);
            assertTrue(course.getCourse_name().equals(course1.getCourse_name()));
            //toma la rta como cadena de texto y verifica q tiene another course
            assertTrue(mvcResult.getResponse().getContentAsString().contains("Another course"));
        }
        //hacer lo mismo pero en productos. y uno en path variable por id.

        @Test
        void getAll_Valid_AllCourses() throws Exception {
            MvcResult mvcResult = mockMvc.perform(get("/courses"))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            assertTrue(mvcResult.getResponse().getContentAsString().contains("Intro to Java"));
            assertTrue(mvcResult.getResponse().getContentAsString().contains("Databases"));
        }
    }

