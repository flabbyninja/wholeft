package com.flabbyninja.wholeft.test.unit;

import com.flabbyninja.wholeft.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("User Domain test")
class UserTest {

    @Test
    @DisplayName("Test age dynamic")
    void testAgeDynamic() {
        User testUser = new User(101L, "MC", "Hammer", 999L, LocalDate.now().minusYears(25), LocalDate.of(2099, Month.DECEMBER, 31));
        assertEquals(testUser.getAge(), 25);
    }

    @Test
    @DisplayName("Test age Fixed")
    void testAgeFixed() {
        User testUser = new User(101L, "MC", "Hammer", 999L, LocalDate.of(1975, Month.DECEMBER, 2), LocalDate.of(2099, Month.DECEMBER, 31));
        assertEquals(testUser.getAge(LocalDate.of(2010, Month.DECEMBER, 2)), 35);
    }
}
