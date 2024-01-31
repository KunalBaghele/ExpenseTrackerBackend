package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Group;
import com.app.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	 public Group addGroup(Group group) {
	        String gname=group.getName();
	        group.setName(gname);
	        return groupRepository.save(group);
	    }

	    public List<Group> getAllGroups() {
	        return groupRepository.findAll();
	    }

	    public Optional<Group> getGroupById(int groupId) {
	        return groupRepository.findById(groupId);
	    }
}
