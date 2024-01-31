package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ParticipantSettlementInfo;
import com.app.service.SettlementService;

@RestController
@RequestMapping("/api/group")
public class GroupController {

	@Autowired
    private SettlementService settlementService;

    @GetMapping("/{groupName}/settlement")
    public List<ParticipantSettlementInfo> getGroupSettlementInfo(@PathVariable String groupName) {
        return settlementService.getGroupSettlementInfo(groupName);
    }


    // Add additional endpoints as needed, for example:
    // - Fetch all group members
    // - Fetch all expenses for a group
    // - Fetch equal share for a group
    // You can customize these endpoints based on your requirements.
}
