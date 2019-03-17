package com.flabbyninja.wholeft;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "my_users")
class User {

    @Id
    private Long id;

    @Column(name = "first_nm")
    private String firstName;

    @Column(name = "last_nm")
    private String lastName;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "birth_dt")
    private LocalDate birthDate;

    @Column(name = "death_dt")
    private LocalDate deathDate;

    int getAge(LocalDate onDate) {
        return Period.between(this.getBirthDate(), onDate).getYears();
    }

    int getAge() {
        return getAge(LocalDate.now());
    }
}
