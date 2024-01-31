package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.Expense;
import com.app.model.Group;
import com.app.model.Participant;
import com.app.repository.ExpenseRepository;
import com.app.repository.GroupRepository;
import com.app.repository.ParticipantRepository;

@Service
public class ExpenseService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private ParticipantRepository participantRepository;

	@Autowired
	private ExpenseRepository expenseRepository;

	public void addExpense(Expense expense) {
		String description = expense.getDescription();
		int pId = expense.getParticipant().getId();
		double amount = expense.getAmount();
		// Retrieve the participant by name and group
		Optional<Participant> participant = participantRepository.findById(pId);

		if (participant == null) {
			// Handle the case where the participant does not exist in the group
			return;
		}

		// Set the participant for the expense
		expense.setParticipant(participant.get());
		expense.setAmount(amount);
		expense.setDescription(description);
		expense.setDateTime(LocalDateTime.now());

		// Save the expense
		expenseRepository.save(expense);
	}

	public Double getTotalExpenseForGroup(String groupName) {
		// Retrieve the group by name
		Group group = groupRepository.findByName(groupName);

		if (group == null) {
			// Handle the case where the group does not exist
			return 0.0;
		}

		// Get the list of participants in the group
		List<Participant> participants = group.getParticipants();

		// Initialize the total expense
		double totalExpense = 0.0;

		// Iterate through each participant to sum up their expenses
		for (Participant participant : participants) {
			List<Expense> expenses = participant.getExpenses();
			for (Expense expense : expenses) {
				totalExpense += expense.getAmount();
			}
		}

		return totalExpense;
	}
}
