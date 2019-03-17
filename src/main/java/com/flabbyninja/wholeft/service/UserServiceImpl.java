package com.flabbyninja.wholeft.service;

import com.flabbyninja.wholeft.UserRepository;
import com.flabbyninja.wholeft.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public List<Long> getParentTree(User user) throws Exception {
        return repo.findById(user.getParentId()).map(data -> {
            return Arrays.asList(data.getId());
        }).orElseThrow(UserServiceException::new);
    }
}
