package com.flabbyninja.wholeft;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(String lastName);
}
