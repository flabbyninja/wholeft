package com.flabbyninja.wholeft.test.integration;

import com.flabbyninja.wholeft.model.User;
import com.flabbyninja.wholeft.service.UserService;
import com.flabbyninja.wholeft.service.UserServiceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("User Service test")
class UserServiceIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("Test parent - one")
    void testParentOne() throws Exception {
        User testUser = new User(101L, "MC", "Hammer", "Black", 1L, LocalDate.now(), LocalDate.of(2099, Month.DECEMBER, 31));
        assertEquals(Arrays.asList(1L), userService.getParentTree(testUser));
    }

    @Test
    @DisplayName("Test parent - doesn't exist")
    void testParentInvalid() {
        User testUser = new User(101L, "MC", "Hammer", "Black", 5555L, LocalDate.now(), LocalDate.of(2099, Month.DECEMBER, 31));
        assertThrows(UserServiceException.class, () ->
                userService.getParentTree(testUser)
        );
    }
}
