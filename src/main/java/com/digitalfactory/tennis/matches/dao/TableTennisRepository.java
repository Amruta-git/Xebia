package com.digitalfactory.tennis.matches.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalfactory.tennis.matches.model.Participant;

public interface TableTennisRepository extends JpaRepository<Participant, Long> {


}
