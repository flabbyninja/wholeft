package com.flabbyninja.wholeft;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private long parentId;

    @Getter
    @Setter
    private LocalDate birthDate;

    @Getter
    @Setter
    private LocalDate deathDate;

    public int getAge(LocalDate onDate) {
        return Period.between(this.getBirthDate(), onDate).getYears();
    }

    public int getAge() {
        return getAge(LocalDate.now());
    }

}
