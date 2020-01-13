package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.groups.Group;
import com.kodilla.ecommercee.domain.groups.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbGroup {
    /*
        @Autowired
        private GroupDao groupDao;

        public List<Group> getGroups() {
            return groupDao.findAll();
        }

        public Optional<Group> getGroupById(final Long groupId) {
            return groupDao.findById(groupId);
        }

        public Group saveGroup(final Group group) {
            return groupDao.save(group);
        }

     */
}
