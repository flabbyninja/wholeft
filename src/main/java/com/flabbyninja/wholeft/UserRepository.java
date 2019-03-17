package com.flabbyninja.wholeft;

import com.flabbyninja.wholeft.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(String lastName);
}
