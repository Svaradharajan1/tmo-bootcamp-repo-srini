package com.galvanize.tmo.paspringstarter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.tmo.paspringstarter.LibraryController;
import com.galvanize.tmo.paspringstarter.dto.BookDTO;
import com.galvanize.tmo.paspringstarter.impl.LibraryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class LibraryControllerTest{

    @Mock
    private LibraryServiceImpl libraryService;

    private LibraryController libraryController;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        libraryController = new LibraryController(libraryService);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void post_Test_Passed() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(libraryController).build();

        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor("Frederick Forsyth");
        bookDTO.setTitle("The Jackal");
        bookDTO.setYearPublished(1979);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO))).andReturn();
        Assertions.assertEquals(result.getResponse().getStatus(), HttpStatus.CREATED.value());
    }

    @Test
    public void get_Test_Passed() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(libraryController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/books")).andReturn();
        Assertions.assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void delete_Test_Passed() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(libraryController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/books")).andReturn();
        Assertions.assertEquals(result.getResponse().getStatus(), HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void post_Test_Failed() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(libraryController).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(null))).andReturn();
        Assertions.assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());
    }

}

