package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Participant;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

}
