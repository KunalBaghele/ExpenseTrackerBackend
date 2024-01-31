package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Expense;
import com.app.model.Group;
import com.app.model.Participant;
import com.app.model.ParticipantSettlementInfo;
import com.app.repository.GroupRepository;

@Service
public class SettlementService {

	@Autowired
	private GroupRepository groupRepository;

	public List<ParticipantSettlementInfo> getGroupSettlementInfo(String groupName) {
		Group group = groupRepository.findByName(groupName);

		if (group == null) {
			return null; // Handle the case where the group does not exist
		}

		List<Participant> participants = group.getParticipants();
		double totalExpense = group.getTotalExpense();
		double equalShare = totalExpense / participants.size();

		// Calculate settlement info for each participant
		return participants.stream().map(participant -> {
			double participantShare = participant.getExpenses().stream().mapToDouble(Expense::getAmount).sum();
			double settlementAmount = participantShare - equalShare;

			return new ParticipantSettlementInfo(participant.getName(), equalShare, settlementAmount);
		}).collect(Collectors.toList());
	}

	
	// Additional methods for fetching all group members, all expenses, etc.
	// Implement these methods based on your specific requirements.
}
