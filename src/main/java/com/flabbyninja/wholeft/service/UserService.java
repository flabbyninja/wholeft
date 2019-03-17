package com.flabbyninja.wholeft.service;

import com.flabbyninja.wholeft.model.User;

import java.util.List;

public interface UserService {

    List<Long> getParentTree(User user) throws Exception;
}
