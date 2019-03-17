package com.flabbyninja.wholeft.test.integration;

import com.flabbyninja.wholeft.UserRepository;
import com.flabbyninja.wholeft.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

//TODO: Refactor tests to clean up Optional usage

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("User Repository Test")
class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository repository;

    @Test
    @DisplayName("Retrieve by ID")
    void testRetrieveByUserId() {
        User validUser = new User(1L, "Frank", "Tank", "Brown", 999L, LocalDate.of(1979, Month.DECEMBER, 25), LocalDate.of(2999, Month.DECEMBER, 25));
        assertEquals(validUser, repository.findById(1L).get());
    }

    @Test
    @DisplayName("Insert User")
    void testInsertUser() {
        Long id = 101L;
        LocalDate birthDate = LocalDate.now();
        User newUser = new User(id, "MC", "Hammer", "Black", 999L, birthDate, LocalDate.of(2999, Month.DECEMBER, 31));
        repository.save(newUser);

        assertEquals(newUser, repository.findById(id).get());
    }

    @Test
    @DisplayName("Update User")
    void testUpdateUser() {
        Long id = 2L;
        User expectedUser = new User(id, "Johnny", "Halfmast", "Green", 1L, LocalDate.of(1946, Month.FEBRUARY, 1), LocalDate.of(2999, Month.DECEMBER, 25));
        User dbUser = repository.findById(id).get();
        assertNotNull(dbUser);
        dbUser.setHairColour("Green");
        repository.save(dbUser);
        assertEquals(expectedUser, repository.findById(id).get());
    }

    @Test
    @DisplayName("Delete User by ID")
    void testDeleteUser() {
        Long id = 2L;
        repository.deleteById(id);
        assertFalse(repository.findById(id).isPresent());
    }
}
