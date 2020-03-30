package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    private String id;
    private String passwd;
    private String name;
    private String email;
    private long ctime; //创建时间
    private double deposit; //保证金
}
