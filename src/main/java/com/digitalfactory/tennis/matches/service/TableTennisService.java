package com.digitalfactory.tennis.matches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalfactory.tennis.matches.dao.TableTennisRepository;
import com.digitalfactory.tennis.matches.model.Participant;

@Service
public class TableTennisService {

	@Autowired
	private TableTennisRepository repo;

	public Participant save(Participant participant) {
		Participant _participant = repo
				.save(new Participant(participant.getId(), participant.getName(), participant.getEmail()));
		return _participant;
	}

	public List<Participant> findAll() {
		return repo.findAll();
	}
}
