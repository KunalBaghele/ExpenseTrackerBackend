package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Participant;
import com.app.service.ParticipantService;

@RestController
@RequestMapping("api/participants")
public class ParticipantController {
	
	@Autowired
	private ParticipantService participantService;

	@GetMapping
	public List<Participant> getAllParticipants() {
		return participantService.getAllParticipants();
	}

	@GetMapping("/{id}")
	public Optional<Participant> getParticipantById(@PathVariable int id) {
		return participantService.getParticipantById(id);
	}

	@PostMapping("/add")
	public void addParticipant(@RequestBody Participant participant) {
		participantService.addParticipant(participant);
	}
}
