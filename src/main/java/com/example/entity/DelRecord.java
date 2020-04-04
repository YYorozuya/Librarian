package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelRecord {
    private int id;
    private String bkid; //书籍id
    private String libid; //图书馆员id
    private Long time; //删除时间
}
