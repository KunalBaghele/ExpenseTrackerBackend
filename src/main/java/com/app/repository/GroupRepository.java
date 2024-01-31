package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

	Group findByName(String groupName);

}
