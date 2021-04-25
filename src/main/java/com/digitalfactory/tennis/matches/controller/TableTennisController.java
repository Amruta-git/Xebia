package com.digitalfactory.tennis.matches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalfactory.tennis.matches.model.Participant;
import com.digitalfactory.tennis.matches.service.TableTennisService;

@RestController
@RequestMapping("/tabletennis")
public class TableTennisController {

	@Autowired
	public TableTennisService m_service;

	@PostMapping("/participants")
	public ResponseEntity<Participant> saveParticipant(@RequestBody Participant participant) {
		Participant _participant = m_service.save(participant);
		return new ResponseEntity<Participant>(_participant, HttpStatus.CREATED);
	}

	@GetMapping("/getAllParticipants")
	public ResponseEntity<List<Participant>> findPartricipant() {
		List<Participant> participantList = m_service.findAll();
		return new ResponseEntity<List<Participant>>(participantList, HttpStatus.OK);
	}

}
