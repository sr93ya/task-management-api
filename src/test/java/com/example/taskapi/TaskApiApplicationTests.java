
package com.example.taskapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthEndpointShouldReturnUP() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void shouldCreateTodo() throws Exception {
        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Complete DevOps assignment\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title")
                        .value("Complete DevOps assignment"))
                .andExpect(jsonPath("$.completed").value(false));
    }

    @Test
    void shouldRetrieveTodos() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(
                        MediaType.APPLICATION_JSON));
    }
}
