package com.flabbyninja.wholeft;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("User Domain test")
public class UserTest {

    @Test
    @DisplayName("Test age dynamic")
    void testAgeDynamic() {
        User testUser = new User(101L, "MC", "Hammer", 999, LocalDate.now().minusYears(25), LocalDate.of(2099, Month.DECEMBER, 31));
        assertEquals(testUser.getAge(), 25);
    }

    @Test
    @DisplayName("Test age Fixed")
    void testAgeFixed() {
        User testUser = new User(101L, "MC", "Hammer", 999, LocalDate.of(1975, Month.DECEMBER, 02), LocalDate.of(2099, Month.DECEMBER, 31));
        assertEquals(testUser.getAge(LocalDate.of(2010, Month.DECEMBER, 02)), 35);
    }
}
