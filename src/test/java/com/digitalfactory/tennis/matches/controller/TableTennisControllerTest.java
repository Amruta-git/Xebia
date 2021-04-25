package com.digitalfactory.tennis.matches.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.digitalfactory.tennis.matches.model.Participant;
import com.digitalfactory.tennis.matches.service.TableTennisService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TableTennisController.class)
public class TableTennisControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();
	@MockBean
	private TableTennisService m_service;

	@Test
	public void testGetAllParticipants() throws Exception {
		List<Participant> participants = Mockito.mock(ArrayList.class);
		when(m_service.findAll()).thenReturn(participants);
		mockMvc.perform(MockMvcRequestBuilders.get("/tabletennis/getAllParticipants"))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
	}

	@Test
	public void testSaveParticipants() throws Exception {
		Participant participant = new Participant();
		participant.setName("Name");
		participant.setEmail("test@gmail.com");
		when(m_service.save(participant)).thenReturn(participant);
		mockMvc.perform(MockMvcRequestBuilders.post("/tabletennis/participants")
				.content(objectMapper.writeValueAsString(participant)).contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}

}
