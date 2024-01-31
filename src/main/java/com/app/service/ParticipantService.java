package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Group;
import com.app.model.Participant;
import com.app.repository.GroupRepository;
import com.app.repository.ParticipantRepository;

@Service
public class ParticipantService {
	@Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }	
    
    public Optional<Participant> getParticipantById(int participantId) {
        return participantRepository.findById(participantId);
    }
    
    public void addParticipant(Participant member) {
        // Check if the group exists
    	String groupName=member.getGroup().getName();
    	String participantName=member.getName();
        Group group = groupRepository.findByName(groupName);

        if (group == null) {
            return;
        }

        // Create a new participant
        Participant participant = new Participant();
        participant.setName(participantName);
        participant.setGroup(group);

        // Add the participant to the group and save the changes
        group.getParticipants().add(participant);
        groupRepository.save(group);

        // Save the participant
        participantRepository.save(participant);
    }
}
