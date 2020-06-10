package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
    private String account;
    private String pwd;
    private String gender;
    private String name;
    private String email;
}
