package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Expense;
import com.app.model.Group;
import com.app.model.Participant;
import com.app.repository.GroupRepository;

@Service
public class ExpenseService {

    @Autowired
    private GroupRepository groupRepository;

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

