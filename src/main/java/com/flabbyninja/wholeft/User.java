package com.flabbyninja.wholeft;

import lombok.*;

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
}
